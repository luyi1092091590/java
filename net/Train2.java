package net;

import java.io.*;
import java.net.Socket;
//客户端
public class Train2 {
    public static void main(String[] args) throws IOException {
//        String hostname = "172.16.22.112";
        String hostname = "127.0.0.1";
        int port = 9999;
        Socket socket = new Socket(hostname,port);
        System.out.println(socket);
        PrintStream printStream = new PrintStream(socket.getOutputStream());
        printStream.println("你好");
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
        System.out.println(reader.readLine());
        printStream.close();
        socket.close();
    }
}
