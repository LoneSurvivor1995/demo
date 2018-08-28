package com.example.demo.controller;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = {"fanout1","fanout2","fanout3"})
public class ReceiveFanout1 {
    @RabbitHandler
    public void receive(String msg){
        System.out.println("ReceiveFanout1 "+msg);
    }
}
