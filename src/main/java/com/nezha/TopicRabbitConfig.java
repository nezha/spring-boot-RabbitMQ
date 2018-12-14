package com.nezha;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by nezha on 2017/4/29.
 */
@Configuration
public class TopicRabbitConfig {
    @Bean
    public Queue queueA() {
        return new Queue("nezha-topic-a");
    }

    @Bean
    public Queue queueB() {
        return new Queue("nezha-topic-b");
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange("nezha-topicExchange");
    }

    @Bean
    Binding bindingExchangeMessage(Queue queueA, TopicExchange exchange) {
        return BindingBuilder.bind(queueA).to(exchange).with("class.math");
    }

    @Bean
    Binding bindingExchangeMessages(Queue queueB, TopicExchange exchange) {
        return BindingBuilder.bind(queueB).to(exchange).with("class.#");
    }
}
