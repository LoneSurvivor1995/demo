package com.example.demo;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.rpc.service.GenericService;

import java.util.HashMap;
import java.util.Map;

public class DubboClient {

    public static void main(String[] args) {
//        Map<Integer,Integer> map = new HashMap();
//        for (int i=0;i<10;i++){
//            map.put(i,i);
//        }
//
//        System.out.println(map.entrySet().size());
//
//        for (Map.Entry entry : map.entrySet()){
//
//        }


        new DubboClient().invoke();
    }

    public void invoke(){
        ApplicationConfig application = new ApplicationConfig("demo-consumer");

        RegistryConfig registry = new RegistryConfig();
        registry.setAddress("zookeeper://127.0.0.1:2181");

        ReferenceConfig<GenericService> reference = new ReferenceConfig<GenericService>();
        reference.setApplication(application);
        reference.setRegistry(registry);
        reference.setInterface("org.apache.dubbo.demo.ApiService");
        reference.setGeneric(true);

        GenericService genericService = reference.get();

        Object result1 = genericService.$invoke("getTask", new String[] {"java.lang.String"}, new Object[] {"world"});
        System.out.println("result1: "+result1);

        Map<String, Object> person = new HashMap<String, Object>();
        person.put("name", "meihao");
        person.put("age", 23);
        Object result2 = genericService.$invoke("getTask", new String[]{"org.apache.dubbo.demo.User"}, new Object[]{person});
        System.out.println("result2: "+result2);

    }
}
