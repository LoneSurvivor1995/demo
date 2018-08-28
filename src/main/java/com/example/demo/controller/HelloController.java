package com.example.demo.controller;

import com.example.demo.config.ZookeeperConfig;
import com.example.demo.entity.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableConfigurationProperties(ZookeeperConfig.class)
public class HelloController {

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    ZookeeperConfig zookeeperConfig;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    @ApiOperation(value = "hello",notes = "hello")
    public String hello(){

        String[] namespaces = zookeeperConfig.getNamespace().split(",");
        for (String str : namespaces){
            System.out.println(str);
        }
        return "hello "+zookeeperConfig;
    }

    @RequestMapping(value = "/test",method = RequestMethod.POST)
    @ApiOperation(value = "test")
    public String test(){
        return "test";
    }

    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    @ApiOperation(value = "insert")
    public String insert(@RequestBody User user){
        mongoTemplate.insert(user);
        return "success";
    }

    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    @ApiOperation(value = "delete")
    public String delete(String id){
        Query query = new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(query,User.class,"user");
        return "success";
    }

    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    @ApiOperation(value = "update")
    public String update(@RequestBody User user){
//        Query query=new Query(Criteria.where("_id").is(user.getId()));
        Update update = Update.update("name", user.getName());
//        mongoTemplate.updateFirst(query, update, User.class);
        return "success";
    }

    @RequestMapping(value = "/updateMulti",method = RequestMethod.PUT)
    @ApiOperation(value = "updateMulti")
    public String updateMulti(@RequestBody User user){
//        Query query=new Query(Criteria.where("_id").is(user.getId()));
        Update update = Update.update("name","950824");
//        mongoTemplate.updateMulti(query,update,User.class);
        return "success";
    }

    @RequestMapping(value = "/queryAll",method = RequestMethod.GET)
    @ApiOperation(value = "queryAll")
    public List<User> queryAll(){
        List<User> users = mongoTemplate.findAll(User.class);
        return users;
    }

    @RequestMapping(value = "/queryByPage",method = RequestMethod.GET)
    @ApiOperation(value = "queryByPage")
    public List<User> delete(){
        Query query = new Query();
        query.skip(2).limit(6);
        List<User> users = mongoTemplate.find(query,User.class);
        return users;
    }


}
