package com.bulain.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;

@EnableTask
@SpringBootApplication
public class TaskBatchApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskBatchApplication.class, args);
	}

}
