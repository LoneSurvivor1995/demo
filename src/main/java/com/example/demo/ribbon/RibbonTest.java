package com.example.demo.ribbon;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.client.RestTemplate;

public class RibbonTest {
    @LoadBalanced
    RestTemplate restTemplate;

    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
    }
}
