package com.example.demo.util;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitmqConfig {

    /*direct*/
    @Bean
    public Queue direct(){
        return new Queue("direct");
    }

    /*topic*/
    @Bean
    public Queue topic1(){
        return new Queue("topicQueue1");
    }

    @Bean
    public Queue topic2(){
        return new Queue("topicQueue2");
    }

    @Bean
    public Queue topic3(){
        return new Queue("topicQueue3");
    }

    @Bean
    public Queue topicTest(){
        return new Queue("topicTest");
    }

    /*fanout*/
    @Bean
    public Queue fanout1(){
        return new Queue("fanout1");
    }

    @Bean
    public Queue fanout2(){
        return new Queue("fanout2");
    }

    @Bean
    public Queue fanout3(){
        return new Queue("fanout3");
    }

    /*topic exchange*/
    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange("topicExchange");
    }

    /*fanout exchange*/
    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("fanoutExchange");
    }

    /*binding topic*/
    @Bean
    Binding bindingTopic1(Queue topic1, TopicExchange topicExchange){
        return BindingBuilder.bind(topic1).to(topicExchange).with("routeKey");
    }

    @Bean
    Binding bindingTopic2(Queue topic2, TopicExchange topicExchange){
        return BindingBuilder.bind(topic2).to(topicExchange).with("routeKey");
    }

    @Bean
    Binding bindingTopic3(Queue topic3, TopicExchange topicExchange){
        return BindingBuilder.bind(topic3).to(topicExchange).with("routeKey");
    }

    @Bean
    Binding bindingTopic4(Queue topic1, TopicExchange topicExchange){
        return BindingBuilder.bind(topic1).to(topicExchange).with("routeKey_2");
    }

    @Bean
    Binding bindingTopic5(Queue topic2, TopicExchange topicExchange){
        return BindingBuilder.bind(topic2).to(topicExchange).with("routeKey_2");
    }

    @Bean
    Binding bindingTopic6(Queue topicTest, TopicExchange topicExchange){
        return BindingBuilder.bind(topicTest).to(topicExchange).with("eee1111");
    }

    /*binding fanout*/
    @Bean
    Binding bindingFanout1(Queue fanout1, FanoutExchange fanoutExchange){
        return BindingBuilder.bind(fanout1).to(fanoutExchange);
    }

    @Bean
    Binding bindingFanout2(Queue fanout2, FanoutExchange fanoutExchange){
        return BindingBuilder.bind(fanout2).to(fanoutExchange);
    }

    @Bean
    Binding bindingFanout3(Queue fanout3, FanoutExchange fanoutExchange){
        return BindingBuilder.bind(fanout3).to(fanoutExchange);
    }
}
