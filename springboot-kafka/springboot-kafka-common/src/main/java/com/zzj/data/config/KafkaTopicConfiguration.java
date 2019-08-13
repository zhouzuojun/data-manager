package com.zzj.data.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(KafkaTopicsProperties.class)
public class KafkaTopicConfiguration {
    private final Logger logger= LoggerFactory.getLogger(this.getClass());

    private final KafkaTopicsProperties kafkaTopicsProperties;

    public KafkaTopicConfiguration(KafkaTopicsProperties kafkaTopicsProperties) {
        this.kafkaTopicsProperties = kafkaTopicsProperties;
    }

    @Bean
    public String[] kafkaTopicName() {
        return kafkaTopicsProperties.getTopicName();
    }

    @Bean
    public String topicGroupId() {
        return kafkaTopicsProperties.getGroupId();
    }
}
