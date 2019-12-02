package dao;

public interface Response {
    //响应行
    void response(Request request) throws Exception;
    //判断是否是动态资源
    boolean isDynamic(String url);
    //判断是否是静态资源
    boolean isStatic(String url);
    //利用反射找响应类，利用响应类的send()方法发送响应体
    void searchClassSend(String fileClass) throws Exception;
}
