package com.nezha.rabbit.topic;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.UUID;

/**
 * Created by nezha on 2017/4/29.
 */
@Component
public class TopicSender implements RabbitTemplate.ConfirmCallback, RabbitTemplate.ReturnCallback {
    @Autowired
    RabbitTemplate amqpTemplate;

    @PostConstruct
    public void init() {
        amqpTemplate.setConfirmCallback(this);
        amqpTemplate.setReturnCallback(this);
    }

    public void send() {
        String context = "hi, i am message :class.english";
        System.out.println("Sender : " + context);
        CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());
        this.amqpTemplate.convertSendAndReceive("nezha-topicExchange", "class.english", context,correlationId);
    }

    public void send1() {
        String context = "hi, i am message ：class.math";
        System.out.println("Sender : " + context);
        CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());
        this.amqpTemplate.convertSendAndReceive("nezha-topicExchange", "class.math", context,correlationId);
    }

    public void send2() {
        String context = "hi, i am messages :class.art";
        System.out.println("Sender : " + context);
        CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());
        this.amqpTemplate.convertSendAndReceive("nezha-topicExchange", "class.art", context,correlationId);
    }

    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        System.out.println(" 回调id:" + correlationData);
        if (ack) {
            System.out.println("消息成功消费");
        } else {
            System.out.println("消息消费失败:" + cause);
        }
    }

    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
        System.out.println(message.getMessageProperties().getCorrelationIdString() + " 发送失败");
    }
}
