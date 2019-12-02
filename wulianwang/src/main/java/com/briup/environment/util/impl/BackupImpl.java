package com.briup.environment.util.impl;

import com.briup.environment.util.Backup;
import com.briup.environment.util.Configuration;
import com.briup.environment.util.ConfigurationAWare;
import com.briup.environment.util.Log;

import java.io.*;
import java.util.Properties;

public class BackupImpl implements Backup, ConfigurationAWare {
    private String path;
    private Log log;

    @Override
    public void init(Properties properties) {
        path = properties.getProperty("path");
    }

    @Override
    public void backup(String fileName, Object data) throws Exception {
        ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(new File(path, fileName)));
        oos.writeObject(data);
        oos.close();
    }

    @Override
    public Object load(String fileName) throws Exception {
        File file = new File(path, fileName);
        if (file.exists()) {
            ObjectInputStream ois = new ObjectInputStream(
                    new FileInputStream(file));
            Object o = ois.readObject();
            return o;
        }
        return null;
    }

    @Override
    public void deleteBackup(String fileName) {
        File file = new File(path,fileName);
        if (file.exists()){
            boolean successful = file.delete();
            if (successful) {
                log.debug("备份文件" + fileName + "删除成功！");
            } else {
                log.warn("备份文件" + fileName + "删除失败！");
            }
        }else {
            log.debug("文件"+fileName+"不存在！");
        }

    }

    @Override
    public void setConfiguration(Configuration configuration) {
        try {
            log = configuration.getLogger();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
