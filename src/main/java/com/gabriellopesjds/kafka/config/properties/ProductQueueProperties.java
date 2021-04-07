package com.gabriellopesjds.kafka.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("kafka.queues.product")
@Getter
@Setter
public class ProductQueueProperties extends AbstractQueueProperties {

}
