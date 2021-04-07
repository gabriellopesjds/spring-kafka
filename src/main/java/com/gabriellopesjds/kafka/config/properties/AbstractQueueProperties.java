package com.gabriellopesjds.kafka.config.properties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AbstractQueueProperties {
    private String name;
    private ReadProperties read;

    @Getter
    @Setter
    public class ReadProperties{
        private String listenerBeanId;
    }
}
