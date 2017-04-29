package com.nezha;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by nezha on 2017/4/29.
 */
@Configuration
public class RabbitConfig {


    //1.配置一个名为hello的一对一的消息队列
    @Bean
    public Queue helloQueue() {
        return new Queue("hello");
    }

    //2.配置一个名为1-m的一对多的消息队列
    @Bean
    public Queue oneToMQueue() {
        return new Queue("1-m");
    }
    ///3.配置一个名为m-m的多对多的消息队列
    @Bean
    public Queue MToMQueue() {
        return new Queue("m-m");
    }
}
