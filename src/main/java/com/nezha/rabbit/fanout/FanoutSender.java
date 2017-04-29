package com.nezha.rabbit.fanout;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by nezha on 2017/4/29.
 */
@Component
public class FanoutSender {
    @Autowired
    AmqpTemplate amqpTemplate;
    public void send() {
        String context = "hi, fanout msg " + new Date();
        System.out.println("Sender : " + context);
        this.amqpTemplate.convertAndSend("fanoutExchange","", context);
    }
}
