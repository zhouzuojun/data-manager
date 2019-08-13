package com.zzj.data.moudles.produre.service.impl;

import com.google.gson.Gson;
import com.zzj.data.moudles.produre.service.ISendService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Service
public class SendService implements ISendService {
    private  final Logger logger= LoggerFactory.getLogger(this.getClass());
    @Override
    public void testSend(){
        Properties props = new Properties();
        props.put("bootstrap.servers", "192.168.111.133:9092,192.168.111.133:9093,192.168.111.133:9094");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        Producer<String, String> producer = new KafkaProducer<>(props);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("user", "zhouzuojun");
        map.put("password", "mypass");
        Gson gson=new Gson();

        logger.info("生产消息开始");
        producer.send(new ProducerRecord<String, String>("my-topic", "msg", gson.toJson(map)));
        producer.close();
        logger.info("消息传输完毕");
    }

    @Override
    public void custom() {
        Properties props = new Properties();
        props.put("bootstrap.servers", "192.168.111.133:9092,192.168.111.133:9093,192.168.111.133:9094");
        props.put("group.id", "consumer");
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Arrays.asList("my-topic"));
        logger.info("开始消费");
        int size=0;
        while (true) {
            logger.info(""+(size++));
            ConsumerRecords<String, String> records = consumer.poll(100);
            for (ConsumerRecord<String, String> record : records)
                logger.error("offset = {}, key = {}, value ={}", record.offset(), record.key(), record.value());
        }
    }
}
