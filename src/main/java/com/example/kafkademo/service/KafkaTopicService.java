package com.example.kafkademo.service;

import com.example.kafkademo.model.Topic;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KafkaTopicService {

    private final KafkaAdmin kafkaAdmin;

    public KafkaTopicService(KafkaAdmin kafkaAdmin) {
        this.kafkaAdmin = kafkaAdmin;
    }

    public void createTopic(Topic topic) {

        NewTopic newTopic = TopicBuilder.name(topic.getTopicName())
                .partitions(topic.getPartition())
                .replicas(topic.getReplica())
                .build();

        AdminClient adminClient = AdminClient.create(kafkaAdmin.getConfigurationProperties());

        adminClient.createTopics(List.of(newTopic));
    }
}
