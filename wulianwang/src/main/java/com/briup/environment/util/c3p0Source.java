package com.briup.environment.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * c3p0连接池设置、获取连接
 */
public class c3p0Source {
    private static ComboPooledDataSource dataSource;

    static {
        dataSource = new ComboPooledDataSource();
        try {
            dataSource.setDriverClass(JdbcUtil.getValue("driver"));
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        dataSource.setJdbcUrl(JdbcUtil.getValue("url"));
        dataSource.setUser(JdbcUtil.getValue("username"));
        dataSource.setPassword(JdbcUtil.getValue("password"));
        dataSource.setInitialPoolSize(10);
        dataSource.setMaxPoolSize(20);
    }

    public static Connection getConnection(){
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}