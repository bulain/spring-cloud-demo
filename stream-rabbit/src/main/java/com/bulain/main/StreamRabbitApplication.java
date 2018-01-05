package com.bulain.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;

@EnableBinding({ Sink.class, Source.class })
@EnableEurekaClient
@SpringBootApplication
public class StreamRabbitApplication {

	public static void main(String[] args) {
		SpringApplication.run(StreamRabbitApplication.class, args);
	}

}
