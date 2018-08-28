package com.example.demo;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;
import com.example.demo.service.ApiService;
import com.example.demo.service.impl.ApiServiceImpl;

import java.io.IOException;

public class DubboServer {
    public static void main( String[] args ) throws IOException {
        /*应用配置*/
        ApplicationConfig applicationConfig = new ApplicationConfig("demo-provider");

        /*注册中心配置*/
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("zookeeper://127.0.0.1:2181");

        /*协议配置*/
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName("dubbo");
        protocolConfig.setPort(20880);

        /*服务配置*/
        ServiceConfig<ApiService> serviceConfig = new ServiceConfig<>();
        serviceConfig.setApplication(applicationConfig);
        serviceConfig.setRegistry(registryConfig);
        serviceConfig.setProtocol(protocolConfig);
        serviceConfig.setInterface(ApiService.class);
        serviceConfig.setRef(new ApiServiceImpl());

        serviceConfig.export();

        System.in.read(); // press any key to exit
    }
}
