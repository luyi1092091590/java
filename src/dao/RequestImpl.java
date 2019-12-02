package dao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RequestImpl implements Request {
    private Socket socket;
    private String method;
    private String url;
    private String protocol;
    private Map<String, String> headMap;
    private Map<String, String> bodyMap;
    private BufferedReader bufferedReader;

    public RequestImpl(Socket socket) throws Exception {
        this.socket = socket;
        headMap = new HashMap<>();
        bodyMap = new HashMap<>();
        bufferedReader = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
    }


    @Override
    public void getInfos() throws Exception {
        //请求行
        String requestLine = bufferedReader.readLine();
        if (requestLine != null) {
            //分割请求行
            String[] strArr = requestLine.split(" ");
            method = strArr[0];
            url = strArr[1];
            protocol = strArr[2];
            //请求头
            String line;
            String[] head;
            while (!"".equals(line = bufferedReader.readLine())) {
                head = line.split(": ", 2);
                headMap.put(head[0], head[1]);
            }
            //请求体，post在请求体中格式 name=2525&code=57，
            // get在uri中格式 /a.txt/?name=2525&code=57,
            if (bufferedReader.ready()) {
                char[] chars = new char[1024];
                int len = bufferedReader.read(chars);
                //截取post请求体
                String string = new String(chars, 0, len);
                System.out.println("请求体==" + string);
                //将请求体分割并放入bodyMap集合中
                splitBody(string);
            } else {
                String[] strings = url.split("[?]");
                System.out.println("hahahahahah---" + Arrays.toString(strings));
                if (strings.length == 2) {
                    splitBody(strings[1]);
                }
            }
        }
    }

    @Override
    public String getMehod() {
        return method;
    }

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public String getProtocol() {
        return protocol;
    }

    @Override
    public Map<String, String> getHead() {
        return headMap;
    }

    @Override
    public Map<String, String> getBody() {
        return bodyMap;
    }

    @Override
    public void splitBody(String string) {
        String[] strings = string.split("[&]");
        for (String elem : strings) {
            String[] strArr = elem.split("[=]");
            if (strArr.length == 2) {
                bodyMap.put(strArr[0], strArr[1]);
            }
        }
    }
}
