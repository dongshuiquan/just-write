package com.dsq.test02;

import org.junit.Test;

/**
 * Created by DELL on 2018/11/14.
 */
public class CoreTest {

    @Test
    public void timeServerTest() throws Exception {
        new TimeServer().bind(8080);
    }

    @Test
    public void timeClientTest() throws Exception {
        new TimeClient().connect(8080, "127.0.0.1");
    }

}
