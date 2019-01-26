package com.dsq.http;

import org.junit.Test;

import java.util.HashMap;

/**
 * Created by DELL on 2018/12/14.
 */
public class HttpTest {

    @Test
    public void testGet() {
        String url = "http://www.baidu.com";
        String s = HttpUtil.doGet(url);
        System.out.println(s);
    }

    @Test
    public void testPost() {
        String url = "http://www.baidu.com";
        String s = null;
        try {
            s = HttpUtil.doPost(url, new HashMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(s);
    }
}
