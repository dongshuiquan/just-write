package com.dsq.jms.topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by DELL on 2017/9/15.
 */
public class AppConsumer {
    private static final String url = "tcp://localhost:61616";
    private static final String topicName = "queue-test";

    public static void main(String[] args) throws JMSException {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
        Connection connection =  connectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination destination =  session.createTopic(topicName);
        MessageConsumer consumer = session.createConsumer(destination);
        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                TextMessage textMessage = (TextMessage) message;
                try {
                    System.out.println("接收消息 ：" + textMessage.getText());

                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
