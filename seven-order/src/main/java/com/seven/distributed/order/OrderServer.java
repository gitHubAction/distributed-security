package com.seven.distributed.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: zhangsh
 * @Date: 2020/4/14 18:14
 * @Version 1.0
 * Description
 */

@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
@EnableFeignClients(basePackages = "com.seven.distributed.order")
public class OrderServer {

    public static void main(String[] args) {
        SpringApplication.run(OrderServer.class,args);
    }
}
