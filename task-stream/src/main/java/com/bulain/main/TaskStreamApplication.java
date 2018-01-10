package com.bulain.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;

@EnableTask
@SpringBootApplication
public class TaskStreamApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskStreamApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner() {
		return new DemoCommandLineRunner();
	}

	public static class DemoCommandLineRunner implements CommandLineRunner {
		private Logger logger = LoggerFactory.getLogger(getClass());

		@Override
		public void run(String... strings) throws Exception {
			logger.info("this is a Test about spring cloud task.");
		}
		
	}
}
