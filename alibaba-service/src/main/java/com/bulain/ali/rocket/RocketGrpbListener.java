package com.bulain.ali.rocket;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile({"dev", "fat", "uat", "prd"})
@Slf4j
@Component
@RocketMQMessageListener(consumerGroup = "MyConsumerGrpb", topic = "MultiTopic", consumeThreadNumber = 1)
public class RocketGrpbListener implements RocketMQListener<MessageExt> {

    public RocketGrpbListener(){
        log.info("init RocketGrpbListener()");
    }

    @Override
    public void onMessage(MessageExt message) {
        log.info("grpb: {}", message);
    }

}
