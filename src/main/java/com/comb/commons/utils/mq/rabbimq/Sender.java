package com.comb.commons.utils.mq.rabbimq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.comb.commons.utils.property.PropertyUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Sender {

    private final static String QUEUE_NAME = "hello";

    /**
     * https://geewu.gitbooks.io/rabbitmq-quick/content/RabbitMQ%E5%9F%BA%E7%A1%80%E6%93%8D%E4%BD%9C.html
     */
    public static void main(String[] argv) throws IOException, TimeoutException {

        String host = PropertyUtil.getValueByKey("rabbitMQ");
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(host);

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        String message = "Hello RabbitMQ World!";
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
        System.out.println(" [x] Sent '" + message + "'");

    }
}