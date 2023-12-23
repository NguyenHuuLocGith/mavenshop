package com.example.cozastore22.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue queue(){
        return new Queue("storage");
    }
    @Bean
    public TopicExchange exchange(){
        return new TopicExchange("exstorage");
    }
    @Bean
    public Binding binding(){
        return BindingBuilder
                .bind(queue())
                .to(exchange())
                .with("/routeStorage");
    }
}
