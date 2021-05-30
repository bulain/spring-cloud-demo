package com.bulain.main;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;

@Slf4j
@Configuration
public class StreamRocketInit {

	@StreamListener(Sink.INPUT)
	public void input(Message<String> message) {
		log.info("{}", message.getPayload());
	}

}
