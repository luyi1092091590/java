package com.briup.environment.client.impl;

import com.briup.environment.bean.Environment;
import com.briup.environment.client.Client;
import com.briup.environment.util.Backup;
import com.briup.environment.util.Configuration;
import com.briup.environment.util.ConfigurationAWare;
import com.briup.environment.util.Log;

import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Collection;
import java.util.Properties;

public class ClientImpl implements Client, ConfigurationAWare {
    private String ip;
    private String port;
    private Log log;
    private Backup backup;
    private String fileName;


    public void send(Collection<Environment> coll) throws Exception {
        //加载备份
        Collection<Environment> oldColl = (Collection<Environment>) backup.load(fileName);
        if (oldColl != null){
            //将oldColl添加到coll集合
            coll.addAll(oldColl);
            //删除备份文件
            backup.deleteBackup(fileName);
        }
        Socket socket = new Socket(ip, Integer.valueOf(port));
        log.debug("socket对象：" + socket);
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        try{
            oos.writeObject(coll);
        }catch (Exception e){
            //发送失败，保存备份
            backup.backup(fileName,coll);
        }
        oos.close();
        //到服务端关闭
//        socket.close();
    }

    public void init(Properties properties) throws Exception {
        ip = properties.getProperty("ip");
        port = properties.getProperty("port");
        fileName = properties.getProperty("backupFile");
    }

    @Override
    public void setConfiguration(Configuration configuration) {
        try {
            log = configuration.getLogger();
            backup = configuration.getBackup();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
