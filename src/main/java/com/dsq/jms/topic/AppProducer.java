package com.dsq.jms.topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by DELL on 2017/9/15.
 */
public class AppProducer {

    private static final String url = "tcp://localhost:61616";
    private static final String topicName = "queue-test";

    public static void main(String[] args) throws JMSException {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
        Connection connection =  connectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination destination =  session.createTopic(topicName);
        MessageProducer producer = session.createProducer(destination);
        for(int i = 0; i < 100; i++) {
            TextMessage textMessage = session.createTextMessage("test" + i);
            producer.send(textMessage);
            System.out.println("发送消息" + textMessage.getText());
        }
        connection.close();
    }
}
