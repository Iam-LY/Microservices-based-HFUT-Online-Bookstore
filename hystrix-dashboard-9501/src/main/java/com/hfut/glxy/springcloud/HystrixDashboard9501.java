package com.hfut.glxy.springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboard9501 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboard9501.class, args);
    }
}
