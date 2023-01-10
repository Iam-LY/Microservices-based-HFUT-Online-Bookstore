package com.hfut.glxy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringCloudGateway9527 {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudGateway9527.class, args);
    }
}