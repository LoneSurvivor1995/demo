package com.example.demo.controller;


import io.swagger.annotations.ApiOperation;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class SenderController {

    @Autowired
    AmqpTemplate amqpTemplate;

    @Autowired
    Environment environment;

    @Value("swagger.apiInfo.title")
    String title;

    @RequestMapping(value = "/send",method = RequestMethod.GET)
    @ApiOperation(value = "send")
    public String send() throws InterruptedException {
        for(int i=0;i<100;i++) {
//            amqpTemplate.convertAndSend("hello", "mh_" + new Date());
//            amqpTemplate.convertAndSend("hello", "mh_" + new Date());
//            amqpTemplate.convertAndSend("hello", "mh_" + new Date());
//            System.out.println("routeKey_2 。。。");
//            amqpTemplate.convertAndSend("topicExchange","routeKey_2",new Date()+" 111");
//            System.out.println("routeKey 。。。");
//            amqpTemplate.convertAndSend("topicExchange","routeKey",new Date()+" 222");
            System.out.println("routeKey eee 。。。");
            amqpTemplate.convertAndSend("topicExchange","eee1111",new Date()+" 222");
            Thread.sleep(50);
        }
        return "sender: "+new Date();
    }

    @RequestMapping(value = "/readProperties",method = RequestMethod.GET)
    @ApiOperation(value = "readProperties")
    public String readProperties(){
        String name = environment.getProperty("name");
        return title+" "+name;
    }

}
