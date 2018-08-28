package com.example.demo.threadPool;

import java.io.IOException;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {

    static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5,10,1000, TimeUnit.SECONDS,new LinkedBlockingDeque<Runnable>(10));

    public static void main(String[] args) {
        int i=0;
        while (i<20){
            i++;
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+" "+threadPoolExecutor.getQueue().size());
                }
            });
        }

        System.out.println(threadPoolExecutor);
        threadPoolExecutor.shutdown();
//        threadPoolExecutor.shutdownNow();

    }
}
