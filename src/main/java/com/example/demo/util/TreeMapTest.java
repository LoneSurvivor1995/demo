package com.example.demo.util;

import com.alibaba.fastjson.JSON;
import com.example.demo.entity.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class TreeMapTest {
//    public static void main(String[] args) {
//        Map<String,String> treemap = new TreeMap<>();
//        treemap.put("a","aa");
//        treemap.put("cc","c");
//        treemap.put("ddd","d");
//        treemap.put("bbbb","b");
//
//        System.out.println(treemap);
//        for (Map.Entry entry : treemap.entrySet()){
//            System.out.println(entry.getKey()+" :"+entry.getValue());
//        }
//    }

    public static void main(String[] args) {
//        System.out.println(new Random().nextInt(10));
        User user = new User();
        user.setName("meihao");
        user.setAge(23);

        int a = 23;

        String b = "string";

        Map<String,Object> map = new HashMap();
        map.put("four",user);
        map.put("a",a);
        map.put("b",b);

        String json = JSON.toJSONString(map);
        System.out.println(json);
    }
}
