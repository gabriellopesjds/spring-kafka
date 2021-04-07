package com.gabriellopesjds.kafka.product.utils;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ConsumerMessage {

    @KafkaListener(topics = "${kafka.queues.product.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumer(final ConsumerRecord consumerRecord) {
        log.info(consumerRecord.toString());
        log.info("key: " + consumerRecord.key());
        log.info("Headers: " + consumerRecord.headers());
        log.info("Partion: " + consumerRecord.partition());
        log.info("Message: " + consumerRecord.value());
    }

}
