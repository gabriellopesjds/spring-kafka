package com.gabriellopesjds.kafka.utils;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class MessageSenderKafka implements MessageSender {

    private final KafkaTemplate kafkaTemplate;

    public void send(String topicName, String message){
        String key = UUID.randomUUID().toString();
        kafkaTemplate.send(topicName, key, message);
    }

}
