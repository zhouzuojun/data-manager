package com.zzj.data.kfka.impl;

import com.zzj.data.kfka.IExampleKafkaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ExampleKafkaService implements IExampleKafkaService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Override
    public void send(String topic, String message) {
        logger.info("消息发送开始：" + System.currentTimeMillis());
        kafkaTemplate.send(topic, message);
        logger.info("消息发送结束："+System.currentTimeMillis());
    }
}
