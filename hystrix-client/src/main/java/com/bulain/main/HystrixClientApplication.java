package com.bulain.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableHystrix
@EnableHystrixDashboard
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class HystrixClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(HystrixClientApplication.class, args);
    }

}
