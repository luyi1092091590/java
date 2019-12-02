package com.briup.environment.util.impl;

import com.briup.environment.util.Log;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.util.Properties;

public class LogImpl implements Log {
    private Logger logger;
    private String fileSrc;


    @Override
    public void init(Properties properties) throws Exception {
        fileSrc = properties.getProperty("log-properties");
        //读取properties文件
        PropertyConfigurator.configure(
                LogImpl.class.getClassLoader().getResource(fileSrc));
        //获取logger对象
        logger = Logger.getRootLogger();
    }


    @Override
    public void debug(String message) {
        logger.debug(message);
    }

    @Override
    public void info(String message) {
        logger.info(message);
    }

    @Override
    public void warn(String message) {
        logger.warn(message);
    }

    @Override
    public void error(String message) {
        logger.error(message);
    }

    @Override
    public void fatal(String message) {
        logger.fatal(message);
    }
}
