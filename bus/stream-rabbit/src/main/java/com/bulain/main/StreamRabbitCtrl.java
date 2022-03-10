package com.bulain.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class StreamRabbitCtrl {

	@Autowired
	@Qualifier(Source.OUTPUT)
	MessageChannel output;

	@RequestMapping("/send")
	public void send() {
		output.send(MessageBuilder.withPayload("This is a demo message")
				.build());
	}

}
