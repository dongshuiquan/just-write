package com.dsq.rmi.zk;


import java.rmi.RemoteException;

/**
 * Created by DELL on 2018/3/26.
 */
public class Server2 {
    public static void main(String[] args) throws Exception {
        publish("localhost", 2099);
    }

    public static void publish(String host, int port) throws RemoteException {
        ServiceProvider provider = new ServiceProvider();
        HelloService helloService = new HelloServiceImpl();
        provider.publish(helloService, host, port);
    }
}
