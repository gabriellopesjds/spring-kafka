package com.gabriellopesjds.kafka.utils;

import com.gabriellopesjds.kafka.config.properties.AbstractQueueProperties;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Setter(onMethod = @__(@Autowired))
public abstract class AsynchronousProcessingForSendMessage<T> {

    private MessageSender messageSender;
    private MessageFormatter messageFormatter;

    public abstract AbstractQueueProperties getQueue();

    public abstract Object buildMessage(T messageObject);

    public void sendMessage(T messageObject){
        String message = messageFormatter.formatMessage(buildMessage(messageObject));
        String queueName = getQueue().getName();
        messageSender.send(queueName, message);
    }
}
