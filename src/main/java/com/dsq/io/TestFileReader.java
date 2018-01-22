package com.dsq.io;

import org.junit.Test;

import java.io.*;

/**
 * Created by DELL on 2018/1/14.
 */
public class TestFileReader {

    @Test
    public void test1() {
        try {
            File file = new File("target/classes/io.txt");
//            System.out.println(file.exists());
//            System.out.println(System.getProperty("user.dir"));
            FileReader reader = new FileReader(file);
            int i = reader.read();
            while(i != -1) {
                System.out.print((char) i);
                i = reader.read();
            }

            FileInputStream inputStream = new FileInputStream(file);
            i = inputStream.read();
            while(i != -1) {
                System.out.print((char) i);
                i = inputStream.read();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
