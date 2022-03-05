package com.bulain.apollo;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@EnableApolloConfig
@SpringBootApplication
public class ApolloClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApolloClientApplication.class, args);
    }

}
