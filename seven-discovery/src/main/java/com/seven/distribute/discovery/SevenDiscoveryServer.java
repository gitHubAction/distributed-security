package com.seven.distribute.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author: zhangsh
 * @Date: 2020/4/16 16:09
 * @Version 1.0
 * Description
 */
@EnableEurekaServer
@SpringBootApplication
public class SevenDiscoveryServer {

    public static void main(String[] args) {
        SpringApplication.run(SevenDiscoveryServer.class);
    }
}
