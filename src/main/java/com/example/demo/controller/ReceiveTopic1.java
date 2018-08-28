package com.example.demo.controller;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
//@RabbitListener(queues = "topicQueue1")
public class ReceiveTopic1 {
//    @RabbitHandler
    public void receive(String hello){

        System.out.println("receiveTopic 111 "+hello +" "+new Date());
    }
}
