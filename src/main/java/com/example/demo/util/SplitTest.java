package com.example.demo.util;

public class SplitTest {
    public static void main(String[] args) {
        String url = "http://localhost:8080/hello";
        String[] urls = url.split("//");
        String a = urls[0];
        String b = urls[1].split("/")[0];
        System.out.println(a+"//"+b+"/hello");
    }
}
