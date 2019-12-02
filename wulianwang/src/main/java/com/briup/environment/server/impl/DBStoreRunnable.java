package com.briup.environment.server.impl;

import com.briup.environment.bean.Environment;
import com.briup.environment.server.DBStore;

import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Collection;

/**
 * 持久化数据的Runnable
 */
public class DBStoreRunnable implements Runnable{
    private Socket socket;
    private DBStore dbStore;

    public DBStoreRunnable(Socket socket,DBStore dbStore) {
        this.socket = socket;
        this.dbStore = dbStore;
    }

    public void run() {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(socket.getInputStream());
            Collection<Environment> coll = (Collection<Environment>) ois.readObject();

            System.out.println("服务端的容器大小：" + coll.size());
            //将数据持久化到数据库
            dbStore.saveDb(coll);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //关闭资源
        try {
            if (ois != null) {
                ois.close();
            }
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
