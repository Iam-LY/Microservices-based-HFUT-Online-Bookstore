package com.hfut.glxy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ServiceProvider8002 {
    public static void main(String[] args) {
        SpringApplication.run(ServiceProvider8002.class, args);
    }
}
