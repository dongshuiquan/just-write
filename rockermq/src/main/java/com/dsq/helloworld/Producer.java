package com.dsq.helloworld;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;


/**
 * Created by aa on 2019/7/28.
 */
public class Producer {
    public static void main(String[] args) throws Exception {
        //创建一个消息生产者，并设置一个消息生产者组
        DefaultMQProducer producer = new DefaultMQProducer("zs_producer_group");
        //指定NameServer地址
        producer.setNamesrvAddr("192.168.43.223:9876");
        producer.setSendMsgTimeout(10_000);
        //初始化Producer，在整个应用生命周期中只需要初始化一次
        producer.start();
        for(int i = 0;i<200;i++) {
            //创建一个消息对象，指定其主题、标签和消息内容
            Message msg = new Message(
                    "topic_example_java"  /*消息主题名*/,
                    "TagA"    /*消息标签*/,
                    ("Hello Java demo RocketMQ" + i).getBytes(RemotingHelper.DEFAULT_CHARSET) /*消息内容*/
            );
            //发送消息并返回结果
            SendResult sendResult = producer.send(msg);

            System.out.printf("%s%n", sendResult);
        }
        //一旦生产者实例不再被使用，则将其关闭，包括清理资源、关闭网络连接等
        producer.shutdown();
    }

}
