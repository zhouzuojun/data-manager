package com.zzj.data.kfka;

public interface IExampleKafkaService {

    /**
     * 消息生产测试
     * @param topic
     * @param message
     */
    void send(String topic , String message);
}
