package com.hfut.glxy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ServiceProvider8003 {
    public static void main(String[] args) {
        SpringApplication.run(ServiceProvider8003.class, args);
    }
}
