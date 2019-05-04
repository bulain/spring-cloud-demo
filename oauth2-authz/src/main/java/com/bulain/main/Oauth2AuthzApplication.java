package com.bulain.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class Oauth2AuthzApplication {

	public static void main(String[] args) {
		SpringApplication.run(Oauth2AuthzApplication.class, args);
	}

}
