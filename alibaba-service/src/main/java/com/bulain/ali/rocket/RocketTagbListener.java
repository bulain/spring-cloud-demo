package com.bulain.ali.rocket;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile({"dev", "fat", "uat", "prd"})
@Slf4j
@Component
@RocketMQMessageListener(consumerGroup = "MyConsumerTagb", topic = "TagTopic", selectorExpression = "tagb", consumeThreadNumber = 1)
public class RocketTagbListener implements RocketMQListener<String> {

    public RocketTagbListener() {
        log.info("init RocketTagbListener()");
    }

    @Override
    public void onMessage(String message) {
        log.info("tagb: {}", message);
    }

}
