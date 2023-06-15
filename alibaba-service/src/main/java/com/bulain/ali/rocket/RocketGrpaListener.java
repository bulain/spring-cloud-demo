package com.bulain.ali.rocket;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.ConsumeMode;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile({"dev", "fat", "uat", "prd"})
@Slf4j
@Component
@RocketMQMessageListener(consumerGroup = "MyConsumerGrpa", topic = "MultiTopic", consumeMode = ConsumeMode.ORDERLY, consumeThreadNumber = 5)
public class RocketGrpaListener implements RocketMQListener<String> {

    public RocketGrpaListener() {
        log.info("init RocketGrpaListener()");
    }

    @Override
    public void onMessage(String message) {
        log.info("grpa: {}", message);
    }

}
