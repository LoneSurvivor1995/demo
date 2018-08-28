package com.example.demo.controller;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
//@RabbitListener(queues = "topicQueue3")
public class ReceiveTopic3 {
//    @RabbitHandler
    public void receive(String hello){

        System.out.println("receiveTopic 333 "+hello +" "+new Date());
    }
}
