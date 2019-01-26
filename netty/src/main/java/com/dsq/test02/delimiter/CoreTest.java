package com.dsq.test02.delimiter;

import com.dsq.test02.TimeClient;
import com.dsq.test02.TimeServer;
import org.junit.Test;

/**
 * Created by DELL on 2018/11/14.
 */
public class CoreTest {

    @Test
    public void timeServerTest() throws Exception {
        new EchoServer().bind(8080);
    }

    @Test
    public void timeClientTest() throws Exception {
        new EchoClient().connect(8080, "127.0.0.1");
    }

}
