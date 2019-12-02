package com.briup.environment.server.impl;

import com.briup.environment.bean.Environment;
import com.briup.environment.server.DBStore;
import com.briup.environment.util.*;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Properties;

public class DBStoreImpl implements DBStore, ConfigurationAWare {
    private Log log;
    private Backup backup;
    private String fileName;


    /**
     * @param coll 需要储存的Environment集合
     * @throws Exception
     */
    public void saveDb(Collection<Environment> coll) throws Exception {
        //从连接池中获取一个连接
        Connection conn = c3p0Source.getConnection();
        log.debug("从线程池获取的连接：" + conn);
        log.debug("当前连接的执行线程：" + Thread.currentThread());
        Statement st = conn.createStatement();
        //设置不自动提交
        conn.setAutoCommit(false);
        //获取容器大小
        final int size = coll.size();
        //记录循环次数
        Integer count = 1;
        //设置批量插入的条数
        final int i = 10000;
        //读取上一次读到的集合位置
        Integer oldCount = (Integer) backup.load(fileName);
        if (oldCount != null) {
            count = oldCount;
            backup.deleteBackup(fileName);
        }
        for (Environment e : ((ArrayList<Environment>) coll).subList(count - 1, size)) {
            try {
                String sql = "insert into e_detail_" + selectTable(e)
                        + "(name,srcId,dstId,sersorAddress,count,cmd,status,data,gather_date) values('"
                        + e.getName() + "'," + e.getSrcId() + "," + e.getDstId()
                        + "," + e.getSersorAddress() + "," + e.getCount() + ","
                        + e.getCmd() + "," + e.getStatus() + "," + e.getData() + ",'"
                        + e.getGather_date() + "')";
//            System.out.println("sql语句："+sql);
                st.addBatch(sql);
                if (count % i == 0 || count == size) {
                    st.executeBatch();
                    conn.commit();
                }
                count++;
            } catch (Exception ee) {
                backup.backup(fileName, count / i * i + 1);
                //错误日志
                log.error("事务提交失败，执行回滚！");
                conn.rollback();
                ee.printStackTrace();
            }
        }
//        System.out.println("数据导入完成！！！！！");
        log.debug("数据导入完成！！！");
        st.close();
        conn.close();
    }

    public void init(Properties properties) throws Exception {
        fileName = properties.getProperty("backupFile");
    }

    private String selectTable(Environment environment) {
        String date = environment.getGather_date().toString();
        //按空格或-符号分割，取出年月日的日
        return date.split("[ -]")[2];
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


//String sql = "insert into e_detail_" + selectTable(e)
//+ "(name,srcId,dstId,sersorAddress,count,cmd,status,data,gather_date)"
//+ "values(?,?,?,?,?,?,?,?,?)";
//pstm = conn.prepareStatement(sql);
//pstm.setString(1, e.getName());
//pstm.setString(2, e.getSrcId());
//pstm.setString(3, e.getDstId());
//pstm.setString(4, e.getSersorAddress());
//pstm.setInt(5, e.getCount());
//pstm.setString(6, e.getCmd());
//pstm.setInt(7, e.getStatus());
//pstm.setFloat(8, e.getData());
//pstm.setTimestamp(9, e.getGather_date());
//pstm.executeUpdate();
//pstm.close()


//    String sql = "insert into e_detail_? (name,srcId,dstId,sersorAddress,count,cmd,status,data,gather_date)"
//            + "values(?,?,?,?,?,?,?,?,?)";
//    PreparedStatement pstm = conn.prepareStatement(sql);
//        pstm.setString(1,selectTable(e));
//        pstm.setString(2, e.getName());
//        pstm.setString(3, e.getSrcId());
//        pstm.setString(4, e.getDstId());
//        pstm.setString(5, e.getSersorAddress());
//        pstm.setInt(6, e.getCount());
//        pstm.setString(7, e.getCmd());
//        pstm.setInt(8, e.getStatus());
//        pstm.setFloat(9, e.getData());
//        pstm.setTimestamp(10, e.getGather_date());
//        System.out.println("sql语句："+sql);
//        System.out.println("pstm对象："+pstm);
//        pstm.addBatch(sql);
//        if (count % i == 0 || count == size) {
//        pstm.executeBatch();
//        conn.commit();
//        }
//        count++;

