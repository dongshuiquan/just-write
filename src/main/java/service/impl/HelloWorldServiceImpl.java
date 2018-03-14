package service.impl;

import org.apache.thrift.TException;
import service.server.HelloWorld;

/**
 * 服务端实现
 *
 * @author tang
 */
public class HelloWorldServiceImpl implements HelloWorld.Iface {

    @Override
    public String sendString(String para) throws TException {
        System.out.println("接收到服务端传来的参数: " + para);
        String result = "服务端成功收到消息";
        return result;
    }

}