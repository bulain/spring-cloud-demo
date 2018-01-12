package com.bulain.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	@RequestMapping(path = "/runner", method = RequestMethod.GET)
	public void runner() {
		String uri = "maven://com.bulain:task-runner:jar:1.0.0-SNAPSHOT";
		List<String> commandArgsList = new ArrayList<String>();
		Map<String, String> environmentProperties = new HashMap<String, String>();
		Map<String, String> deploymentProperties = new HashMap<String, String>();
		TaskLaunchRequest request = new TaskLaunchRequest(uri, commandArgsList,
				environmentProperties, deploymentProperties, "task-runner");
		source.output().send(new GenericMessage<TaskLaunchRequest>(request));
	}
	
	@RequestMapping(path = "/batch", method = RequestMethod.GET)
	public void batch() {
		String uri = "maven://com.bulain:task-batch:jar:1.0.0-SNAPSHOT";
		List<String> commandArgsList = new ArrayList<String>();
		Map<String, String> environmentProperties = new HashMap<String, String>();
		Map<String, String> deploymentProperties = new HashMap<String, String>();
		TaskLaunchRequest request = new TaskLaunchRequest(uri, commandArgsList,
				environmentProperties, deploymentProperties, "task-batch");
		source.output().send(new GenericMessage<TaskLaunchRequest>(request));
	}

}
