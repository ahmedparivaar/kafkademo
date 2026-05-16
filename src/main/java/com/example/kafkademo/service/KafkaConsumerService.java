package com.example.kafkademo.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Service

public class KafkaConsumerService {

    private static final Logger log =
            LoggerFactory.getLogger(KafkaConsumerService.class);

    @KafkaListener(
            topicPartitions = @TopicPartition(
                    topic = "metro",
                    partitions = {"0"}
            ),
            groupId = "my-group"
    )
    public void consumeFromZeroPartition(String message) {
        log.info("Received Message From Partition 0 : {}" , message);
    }

    @KafkaListener(
            topicPartitions = @TopicPartition(
                    topic = "metro",
                    partitions = {"1"}
            ),
            groupId = "my-group"
    )
    public void consumeFromOnePartition(String message) {
        log.info("Received Message From Partition 1 : {}" , message);
    }
}