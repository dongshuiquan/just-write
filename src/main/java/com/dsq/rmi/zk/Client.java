package com.dsq.rmi.zk;

/**
 * Created by DELL on 2018/3/26.
 */
public class Client {
    public static void main(String[] args) throws Exception {
        ServiceConsumer consumer = new ServiceConsumer();

        while (true) {
            HelloService helloService = consumer.lookup();
            String result = helloService.service("Jack");
            System.out.println(result);
            Thread.sleep(3000);
        }
    }
}
