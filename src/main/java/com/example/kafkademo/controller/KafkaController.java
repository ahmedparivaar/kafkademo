package com.example.kafkademo.controller;


import com.example.kafkademo.model.Topic;
import com.example.kafkademo.service.KafkaProducerService;
import com.example.kafkademo.service.KafkaTopicService;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

    private final KafkaProducerService kafkaProducerService;
    private final KafkaTopicService kafkaTopicService;

    public KafkaController(KafkaProducerService kafkaProducerService , KafkaTopicService kafkaTopicService) {
        this.kafkaProducerService = kafkaProducerService;
        this.kafkaTopicService=kafkaTopicService;
    }

    @PostMapping("/publish")
    public String publish(@RequestParam String message , String topicName,int partition) {

        kafkaProducerService.sendMessage(message,topicName, partition);

        return "Message Published Successfully";
    }

    @PostMapping("/topic/create")
    public ResponseEntity<String> createTopic(@RequestBody Topic topic)
    {
         kafkaTopicService.createTopic(topic);

         return ResponseEntity.ok("Topic created...");
    }
}