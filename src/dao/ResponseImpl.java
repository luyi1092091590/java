package dao;

import Servlet.Servlet;
import util.PropFinder;
import util.ServletFinder;
import Servlet.load;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.Socket;

public class ResponseImpl implements Response {
    private Socket socket;
    private Request request;


    public ResponseImpl(Socket socket, Request request) {
        this.socket = socket;
        this.request = request;
    }

    @Override
    public void response(Request request) throws Exception {
        String url = request.getUrl();
        System.out.println("url===" + url);
        if (url != null) {
            String[] arr = url.split("[/.]");
            String fileClass = arr[1];
            //依次判断动态资源、静态资源或者不存在
            //响应行、头、体都封装在Servlet中
            if (arr.length > 3) {
                if (new File(PropFinder.getValue("resourcePath"), url).exists()) {
                    new load(socket, request).send();
                }else {
                    socket.close();
                }
            } else if (isDynamic(url)) {
                searchClassSend(ServletFinder.getClassName(fileClass));
            } else if (isStatic(url)) {
                searchClassSend(ServletFinder.getClassName(fileClass));
            } else {
                searchClassSend(ServletFinder.getClassName("error"));
            }
        }
    }


    @Override
    public boolean isDynamic(String url) {
        String resourcePath = PropFinder.getValue("resourcePath");
        File file = new File(resourcePath, url);
        if (file.exists()) {
            return false;
        } else {
            String path = url.split("[/.]")[1];
            System.out.println("分割==" + path);
            File file1 = new File(
                    "D:\\IDEA_workspace\\WebServer\\src\\Servlet", path + ".java");
            System.out.println("绝对路径：" + file1);
            System.out.println("是否以.action结尾" + url.endsWith(".action"));
            System.out.println("文件是否存在" + file1.exists());
            //判断以.action为后缀并且该类存在项目中
            if (url.endsWith(".action") && file1.exists()) {
                System.out.println("动态资源");
                return true;
            } else {
                return false;
            }
        }
    }

    @Override
    public boolean isStatic(String url) {
        String resourcePath = PropFinder.getValue("resourcePath");
        File file = new File(resourcePath, url);
        if (file.exists()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void searchClassSend(String fileClass) throws Exception {
        Class<?> clazz = Class.forName(fileClass);
        //获取2参构造器
        Constructor constructor = clazz.getConstructor(Socket.class, Request.class);
        Servlet servlet = (Servlet) constructor.newInstance(socket, request);
        Method method = clazz.getMethod("send");
        method.invoke(servlet);
    }
}
