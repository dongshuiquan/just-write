package com.dsq.third;

import io.netty.channel.Channel;

import java.util.UUID;

/**
 * Created by DELL on 2018/12/4.
 */
public class ImClientApp {
    public static void main(String[] args) {
        String host = "127.0.0.1";
        int port = 8080;
        Channel channel = new ImConnection().connect(host, port);
        String id = UUID.randomUUID().toString().replaceAll("-", "");
        // protobuf
        MessageProto.Message message = MessageProto.Message.newBuilder().setId(id).setContent("hello yinjihuan").build();
        channel.writeAndFlush(message);
    }

}
