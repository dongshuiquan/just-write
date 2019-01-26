package com.dsq.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by dong on 2018/6/9.
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        while (true) {
            Socket socket = serverSocket.accept();
            byte[] bytes = new byte[1000];
            InputStream inputStream = socket.getInputStream();
            inputStream.read(bytes);
            System.out.println(new String(bytes));
        }


    }
}
