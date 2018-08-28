package com.example.demo.service.impl;

import com.example.demo.service.ApiService;

public class ApiServiceImpl implements ApiService {
    @Override
    public String one(String a) {
        return a;
    }

    @Override
    public String two(String a, String b) {
        return a+" "+b;
    }
}
