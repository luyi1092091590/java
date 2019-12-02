package dao;

import java.util.Map;

public interface Request {
    //接收请求行
    void getInfos() throws Exception;

    //接收请求方法
    String getMehod();

    //接收url
    String getUrl();

    //接收协议版本
    String getProtocol();

    //接收请求头
    Map<String, String> getHead();

    //接收请求体
    Map<String, String> getBody();

    //分割请求体并存入Map集合中
    void splitBody(String string);
}
