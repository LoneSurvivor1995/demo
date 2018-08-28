package com.example.demo.hystrix;

import com.netflix.hystrix.*;

import java.util.HashMap;
import java.util.Observable;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class HelloWorldCommand extends HystrixCommand<String>{
//        public HelloWorldCommand(String name) {
//            //最少配置:指定命令组名(CommandGroup)
//            super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
//            this.name = name;
//        }

    public HelloWorldCommand(String name) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("name"))
                .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("name"))
                .andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter()
                        .withCoreSize(1)
                        .withMaxQueueSize(2)
                        .withQueueSizeRejectionThreshold(10)
                )
                .andCommandKey(HystrixCommandKey.Factory.asKey("name"))
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                        .withExecutionTimeoutInMilliseconds(5000)
                        /*开启熔断降级*/
                        .withCircuitBreakerEnabled(true)
                        /*请求成功条数比例低于90%，断路器状态修改为开路*/
                        .withCircuitBreakerErrorThresholdPercentage(90)
                        /*最小请求量为10*/
                        .withCircuitBreakerRequestVolumeThreshold(5)
                        /*统计周期为10s*/
                        .withCircuitBreakerSleepWindowInMilliseconds(10000)
                        /*设置请求隔离级别为信号量隔离*/
                        .withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrategy.SEMAPHORE)
                        .withExecutionIsolationSemaphoreMaxConcurrentRequests(10)
                        .withFallbackIsolationSemaphoreMaxConcurrentRequests(10)



//                        .withMetricsRollingPercentileBucketSize(7)
//                        .withMetricsRollingPercentileWindowBuckets(10)

//                        .withMetricsRollingStatisticalWindowBuckets(70000)
//
//                        .withExecutionIsolationSemaphoreMaxConcurrentRequests(100)
                        /*失败重试间隔时间*/
                        .withCircuitBreakerSleepWindowInMilliseconds(100000)));
    }

    @Override
    protected String run() throws Exception {
        index.getAndIncrement();
//        System.out.println(Thread.currentThread().getName()+" "+index);
        return "";
        }



        static AtomicInteger index = new AtomicInteger(0);
    //调用实例
    public static void main(String[] args) throws Exception{
        final ExecutorService executor = Executors.newFixedThreadPool(100);
        for (int i=0;i<10000;i++){
//            Thread.sleep(10);
//            System.out.println(index+" "+i);
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
//                        Thread.sleep(5000);
                        new HelloWorldCommand("hystrix").queue().get();//.queue().get();
//                        System.out.println(executor);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        }


    @Override
    protected String getFallback() {
        return "this is fallback ...";
    }
}
