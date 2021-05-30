package com.bulain.main;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class StreamRocketCtrl {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @RequestMapping("/send")
    public void send() {
        String msgBody = "This is a demo message";
        rocketMQTemplate.send("cloud-topic", MessageBuilder.withPayload(msgBody).build());
    }

}
