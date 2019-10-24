package net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Train1 {
    private static boolean isStop = false;
    public static void main(String[] args) throws IOException {
        int port = 9999;
        ServerSocket ss = new ServerSocket(port);
        System.out.println(ss);
        while (!isStop) {
            Socket socket = ss.accept();
            System.out.println(socket);
            InputStream is = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String info = reader.readLine();
            System.out.println(socket.getLocalAddress() + "...:" + info);
            PrintStream printStream = new PrintStream(socket.getOutputStream());
            printStream.println("已收到！");
            reader.close();
            is.close();
            socket.close();
        }
        ss.close();
    }

}
