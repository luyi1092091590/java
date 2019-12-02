package com.briup.environment.util.impl;

import com.briup.environment.client.Client;
import com.briup.environment.client.Gather;
import com.briup.environment.server.DBStore;
import com.briup.environment.server.Server;
import com.briup.environment.util.*;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.net.URL;
import java.util.*;

public class ConfigurationImpl implements Configuration {
    private Element root;
    private Map<String, WossModuleInit> map = new HashMap<>();

    public Map<String, WossModuleInit> getMap() {
        return map;
    }

    public ConfigurationImpl() {
        SAXReader xmlReader = new SAXReader();
        URL url = ConfigurationImpl.class.getClassLoader().getResource("config.xml");
        try {
            Document doc = xmlReader.read(url);
            root = doc.getRootElement();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Iterator<Element> iterator = root.elementIterator();
        while (iterator.hasNext()) {
            Element elem = iterator.next();
            Iterator<Element> iterator1 = elem.elementIterator();
            Properties prop = new Properties();
            while (iterator1.hasNext()) {
                Element elem1 = iterator1.next();
                prop.put(elem1.getName(), elem1.getText());
            }
            try {
                WossModuleInit o = (WossModuleInit) instance(elem.attributeValue("class"));
                //实例对象放入容器
                map.put(elem.getName(), o);
                o.init(prop);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        for (WossModuleInit wossModuleInit : map.values()){
            if (wossModuleInit instanceof ConfigurationAWare) {
                //注入模块的实例对象
                ((ConfigurationAWare) wossModuleInit).setConfiguration(this);
            }
        }
    }

    @Override
    public Log getLogger() throws Exception {
        return (Log) map.get("logger");
    }

    @Override
    public Server getServer() throws Exception {
        return (Server) map.get("server");
    }

    @Override
    public Client getClient() throws Exception {
        return (Client) map.get("client");
    }

    @Override
    public DBStore getDbStore() throws Exception {
        return (DBStore) map.get("dbstore");
    }

    @Override
    public Gather getGather() throws Exception {
        return (Gather) map.get("gather");
    }

    @Override
    public Backup getBackup() throws Exception {
        return (Backup) map.get("backup");
    }

    private Object instance(String className) throws Exception {
        Class c = Class.forName(className);
        return c.newInstance();
    }

}
