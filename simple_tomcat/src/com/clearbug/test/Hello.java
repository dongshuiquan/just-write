package com.clearbug.test;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by clearbug on 2017/4/30.
 */
public class Hello {

    public static void main(String[] args) throws IOException {
        System.out.println("Hello, World");
        System.out.println(System.getProperty("user.dir"));
        Socket socket = new Socket("www.baidu.com", 80);
    }
}
