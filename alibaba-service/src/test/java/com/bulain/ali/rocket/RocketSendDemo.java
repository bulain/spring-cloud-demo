package com.bulain.ali.rocket;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.apache.rocketmq.spring.support.RocketMQHeaders;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.ActiveProfiles;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@ActiveProfiles("test")
@SpringBootTest
public class RocketSendDemo {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @BeforeAll
    public static void setUp() {
        //System.setProperty("rocketmq.client.logUseSlf4j", "true");
    }

    @Test
    void testMultiSend() {
        Map<String, Object> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put("id", i);
            map.put("name", "name-" + i);
            String payload = JSON.toJSONString(map);
            Message<String> msg = MessageBuilder.withPayload(payload)
                    .setHeader(RocketMQHeaders.KEYS, "KEY_" + i)
                    .build();
            SendResult result = rocketMQTemplate.syncSend("MultiTopic", msg);
            log.info("MultiTopic: {}", result);
        }
    }

    @Test
    void testOrderlySend() {
        Map<String, Object> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put("id", i);
            map.put("name", "name-" + i);
            String payload = JSON.toJSONString(map);
            Message<String> msg = MessageBuilder.withPayload(payload)
                    .setHeader(RocketMQHeaders.KEYS, "KEY_" + i)
                    .build();
            String hashkey = Integer.toString(i / 3);
            SendResult result = rocketMQTemplate.syncSendOrderly("MultiTopic", msg, hashkey);
            log.info("MultiTopic: {}", result);
        }
    }


    @Test
    void testTagSend() {
        Map<String, Object> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put("id", i);
            map.put("name", "name-" + i);
            String payload = JSON.toJSONString(map);
            Message<String> msg = MessageBuilder.withPayload(payload)
                    .setHeader(RocketMQHeaders.KEYS, "KEY_" + i)
                    .build();

            SendResult result = null;
            if (i % 2 == 0) {
                result = rocketMQTemplate.syncSend("TagTopic:taga", msg);
            } else {
                result = rocketMQTemplate.syncSend("TagTopic:tagb", msg);
            }
            log.info("TagTopic: {}", result);
        }
    }

}
