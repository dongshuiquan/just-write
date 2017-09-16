package com.dsq.jms.spring;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Created by DELL on 2017/9/16.
 */
public class ConsumerMessageListener implements MessageListener {
    @Override
    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;
        try {
            System.out.println("接收消息 ：" + textMessage.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
