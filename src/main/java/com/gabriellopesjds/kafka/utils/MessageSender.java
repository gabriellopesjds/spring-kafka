package com.gabriellopesjds.kafka.utils;

public interface MessageSender {

    void send(String topicName, String message);

}
