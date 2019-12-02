package com.briup.environment.client.impl;

import com.briup.environment.bean.Environment;
import com.briup.environment.client.Gather;
import com.briup.environment.util.Backup;
import com.briup.environment.util.Configuration;
import com.briup.environment.util.ConfigurationAWare;
import com.briup.environment.util.Log;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.*;

public class GatherImpl implements Gather, ConfigurationAWare {
    private Log log;
    private String fileSrc;
    private Backup backup;
    private String fileName;


    public Collection<Environment> gather() throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(fileSrc));
        String str = "";
        List<Environment> environments = new ArrayList<>();
        String[] strings = null;
        //记录读取的字符的长度
        long charlen = 0L;
        //加载备份
        Long oldCharLen = (Long) backup.load(fileName);
        if (oldCharLen != null) {
            //跳过上一次已经读取的字符长度
            br.skip(oldCharLen);
            //重新记录此次开始读取的字符长度
            charlen = oldCharLen;
            //删除备份
            backup.deleteBackup(fileName);
        }
        while ((str = br.readLine()) != null) {
            //累加记录读取的字符长度
            charlen += str.length() + 2;
            strings = str.split("[|]");
            if (strings.length == 9) {
                addEnvironment(strings, environments);
            } else {
                //用日志记录错误
                log.warn("数据切分后不是9段！");
            }
        }
//        PrintWriter pw = new PrintWriter(new File("list.txt"));
//        for (Environment e : environments) {
//            pw.println(e.toString());
//        }
//        pw.close();
        br.close();
//        System.out.println("客户端容器大小："+environments.size());
        log.debug("容器大小：" + environments.size());
        //备份此次采集的字符长度
//        backup.backup(fileName, charlen);
        return environments;
    }

    /**
     * @param properties 一个Properties实例封装了初始化所需的各种配置信息
     * @throws Exception
     */
    public void init(Properties properties) throws Exception {
        fileSrc = properties.getProperty("src-file");
        fileName = properties.getProperty("charNum");
    }

    /**
     * 把属性设置好并添加到list中
     *
     * @param strings
     * @param list
     */
    private void addEnvironment(String[] strings, List<Environment> list) {
        Environment environment = new Environment();
        if (strings[3].equals("16")) {
            //十六进制前两个字节的十进制温度
            float temperature = Integer.valueOf(strings[6].substring(0, 4), 16) * 0.00268127F - 46.85F;
            //十六进制中间两个字节的十进制湿度
            float humidity = Integer.valueOf(strings[6].substring(4, 8), 16) * 0.00190735F - 6F;
            environment.setName("温度");
            environment.setData(temperature);
            setEnvironment(strings, environment);
            //温度数据添加到容器
            list.add(environment);

            environment = new Environment();
            environment.setName("湿度");
            environment.setData(humidity);
            setEnvironment(strings, environment);
            //湿度数据添加到容器
            list.add(environment);
        } else if (strings[3].equals("256")) {
            //十六进制前两个字节的十进制光照强度
            float illumination = Integer.valueOf(strings[6].substring(0, 4), 16);
            environment.setName("光照强度");
            environment.setData(illumination);
            setEnvironment(strings, environment);
            list.add(environment);

        } else if (strings[3].equals("1280")) {
            //十六进制前两个字节的十进制二氧化碳
            float co2 = Integer.valueOf(strings[6].substring(0, 4), 16);
            environment.setName("二氧化碳");
            environment.setData(co2);
            setEnvironment(strings, environment);
            list.add(environment);
        } else {
            //用日志记录错误
            log.warn("没有这个数字表示的环境参数！");
        }
    }

    /**
     * 字符串转时间戳
     *
     * @param str
     * @return
     */
    private Timestamp stringToTime(String str) {
        Timestamp timestamp = new Timestamp(Long.valueOf(str));
        return timestamp;
    }

    /**
     * set除name和data属性
     *
     * @param strings
     * @param environment
     */
    private void setEnvironment(String[] strings, Environment environment) {
        //String name, String srcId, String dstId, String devId,
        //			String sersorAddress, int count, String cmd, int status,
        //			float data, Timestamp gather_date
        environment.setSrcId(strings[0]);
        environment.setDstId(strings[1]);
        environment.setDevId(strings[2]);
        environment.setSersorAddress(strings[3]);
        environment.setCount(Integer.valueOf(strings[4]));
        environment.setCmd(strings[5]);
        environment.setStatus(Integer.valueOf(strings[7]));
        environment.setGather_date(stringToTime(strings[8]));
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
