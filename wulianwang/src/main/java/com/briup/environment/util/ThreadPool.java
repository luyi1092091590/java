package com.briup.environment.util;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 设置线程池并获取
 */
public class ThreadPool {
    private static final BlockingQueue arrayqueue = new ArrayBlockingQueue(5);

    public static ThreadPoolExecutor getThread(){
        //基本线程数，最大线程数,空闲线程存活时间，keepAliveTime的单位，缓存任务的排队策略
        return new ThreadPoolExecutor(10,20,1, TimeUnit.MINUTES,arrayqueue);
    }
}
