package com.seven.distributed.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @Author: zhangsh
 * @Date: 2020/4/17 10:52
 * @Version 1.0
 * Description
 */
@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class SevenGatewayServer {

    public static void main(String[] args) {
        SpringApplication.run(SevenGatewayServer.class,args);
    }
}
