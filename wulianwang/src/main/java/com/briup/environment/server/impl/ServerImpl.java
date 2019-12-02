package com.briup.environment.server.impl;

import com.briup.environment.server.DBStore;
import com.briup.environment.server.Server;
import com.briup.environment.util.Configuration;
import com.briup.environment.util.ConfigurationAWare;
import com.briup.environment.util.Log;
import com.briup.environment.util.ThreadPool;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;

public class ServerImpl implements Server, ConfigurationAWare {
    private Log log;
    private DBStore dbStore;
    private boolean isStop = false;
    private String port;


    public void receiver() throws Exception {
        ServerSocket ss = new ServerSocket(Integer.valueOf(port));
        while (!isStop) {
            Socket socket = ss.accept();
            System.out.println("log对象：" + log);
            log.debug("服务器socket对象：" + socket);
            //用线程池执行
            ThreadPool.getThread().execute(new DBStoreRunnable(socket,dbStore));
        }
    }

    public void shutdown() {
        isStop = true;
    }

    public void init(Properties properties) throws Exception {
        port = properties.getProperty("port");
    }

    @Override
    public void setConfiguration(Configuration configuration) {
        try {
            log = configuration.getLogger();
            dbStore = configuration.getDbStore();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
