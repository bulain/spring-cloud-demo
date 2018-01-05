package com.bulain.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;

@Configuration
public class StreamRabbitInit {
	private final Logger logger = LoggerFactory.getLogger(getClass());

	@StreamListener(Sink.INPUT)
	public void input(Message<String> message) {
		logger.info("{}", message.getPayload());
	}

}
