package com.dsq.first;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

/**
 * Created by DELL on 2018/12/3.
 */
public class MyHttpHandler extends SimpleChannelInboundHandler<HttpObject> {

    int count;
    String uri;

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, HttpObject msg) throws Exception {
        if(msg instanceof HttpRequest)
        {
            HttpRequest request = (HttpRequest) msg;
            uri = request.getUri();
            System.out.println("HttpRequest : " + count++);
            System.out.println(msg.toString());//打印httpRequest
        }

        if(msg instanceof HttpContent)
        {
            System.out.println("HttpContent : " + count++);
            System.out.println(msg.toString());
            if("/hello".equals(uri)) {
                HttpResponse httpResponse = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, Unpooled.wrappedBuffer("hello client".getBytes()));//建立httpResponse
                httpResponse.headers().add(HttpHeaders.Names.CONTENT_TYPE, "text/plain");
                httpResponse.headers().add(HttpHeaders.Names.CONTENT_LENGTH, 12);

                ctx.writeAndFlush(httpResponse);//返回响应的httpResponse
            } else {
                HttpResponse httpResponse = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, Unpooled.wrappedBuffer("bad request".getBytes()));//建立httpResponse
                httpResponse.headers().add(HttpHeaders.Names.CONTENT_TYPE, "text/plain");
                httpResponse.headers().add(HttpHeaders.Names.CONTENT_LENGTH, 11);

                ctx.writeAndFlush(httpResponse);//返回响应的httpResponse
            }
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
        cause.printStackTrace();
    }
}
