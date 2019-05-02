package com.dsq.spring.queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * Created by dong on 2019/5/2.
 */
@Component
public class QueueProducer {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private Destination queueTextDestination;//配置文件applicationContext-jms-producer.xml点对点文本信息bean的id

    public QueueProducer() {
    }

    /**
     * 发送文本消息
     * @param text
     */
    public void sendTextMessage(final String text){
        jmsTemplate.send(queueTextDestination, new MessageCreator() {

            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(text);
            }
        });
    }

}