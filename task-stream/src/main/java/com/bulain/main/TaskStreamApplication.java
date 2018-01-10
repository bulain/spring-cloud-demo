package com.bulain.main;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.cloud.task.launcher.TaskLaunchRequest;
import org.springframework.cloud.task.launcher.annotation.EnableTaskLauncher;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@EnableBinding(Source.class)
@RestController
@EnableTaskLauncher
@SpringBootApplication
public class TaskStreamApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskStreamApplication.class, args);
	}

	@Autowired
	private Source source;

	@RequestMapping(path = "/launcher", method = RequestMethod.GET)
	public void publishTask() {
		String uri = "maven://com.bulain:task-runner:jar:1.0.0-SNAPSHOT";
		List<String> commandArgsList = new ArrayList<>();
		TaskLaunchRequest request = new TaskLaunchRequest(uri, commandArgsList,
				null, null, "task-runner");
		source.output().send(new GenericMessage<TaskLaunchRequest>(request));
	}

}
