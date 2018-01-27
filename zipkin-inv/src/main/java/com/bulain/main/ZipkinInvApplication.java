package com.bulain.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ZipkinInvApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZipkinInvApplication.class, args);
    }

}
