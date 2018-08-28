///*
//package com.example.demo.config;
//
//import org.apache.curator.RetryPolicy;
//import org.apache.curator.framework.CuratorFramework;
//import org.apache.curator.framework.CuratorFrameworkFactory;
//import org.apache.curator.retry.ExponentialBackoffRetry;
//
//import java.util.List;
//
//public class Zookeeper {
//    public void go(){
//        System.out.println("execute go");
//    }
//
//    //创建简单的 CuratorFramework
//    public static CuratorFramework createSimple(String connectionString)
//    {
//        ExponentialBackoffRetry retryPolicy = new ExponentialBackoffRetry(1000, 3);
//        return CuratorFrameworkFactory.newClient(connectionString, retryPolicy);
//    }
//
//    //创建复杂的CuratorFramework
//    public static CuratorFramework  createWithOptions(String connectionString, RetryPolicy retryPolicy, int connectionTimeoutMs, int sessionTimeoutMs)
//    {
//        return CuratorFrameworkFactory.builder()
//                .connectString(connectionString)
//                .retryPolicy(retryPolicy)
//                .connectionTimeoutMs(connectionTimeoutMs)
//                .sessionTimeoutMs(sessionTimeoutMs)
//                // etc. etc.
//                .build();
//    }
//
//    public static void main(String[] args) throws Exception {
//        CuratorFramework curatorFramework = Zookeeper.createSimple("127.0.0.1:2181");
//        curatorFramework.start();
////        curatorFramework.create().forPath("/edsp/consumer", "comsumer01".getBytes());
////        curatorFramework.create().forPath("/edsp/provider", "provider01".getBytes());
//        byte[] bytes = curatorFramework.getData().forPath("/edsp");
//        String str = new String(bytes,"UTF-8");
//        System.out.println(str);
//        String parent = "/edsp";
//        List<String> list = curatorFramework.getChildren().forPath(parent);
//        if (list.size()>0){
//            for (String l : list){
//                byte[] byte1 = curatorFramework.getData().forPath(parent+"/"+l);
//                String st = new String(byte1,"UTF-8");
//                System.out.println(l+" "+st);
//            }
//            System.out.println(list);
//        }
//
//    }
//}*/
