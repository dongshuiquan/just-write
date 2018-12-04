package com.dsq.third;

import io.netty.channel.Channel;

import java.util.UUID;

/**
 * Created by DELL on 2018/12/4.
 */
public class ImServerApp {
    public static void main(String[] args) {
        ImServer server = new ImServer();
        server.run(8080);
    }

}
