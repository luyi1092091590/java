package com.briup.environment.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 读取properties文件并获取jdbc设置
 */
public class JdbcUtil {
    private static Properties prop;
    static {
        prop = new Properties();
        InputStream in = JdbcUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
        try {
            prop.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String getValue(String key){
        return prop.getProperty(key);
    }
}
