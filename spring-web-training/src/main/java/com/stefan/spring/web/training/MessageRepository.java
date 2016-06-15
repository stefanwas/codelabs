package com.stefan.spring.web.training;


import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class MessageRepository {

    private final Map<String, Message> messages = new LinkedHashMap<>();

    public Message getMessageById(String id) {
        return messages.get(id);
    }

    public Collection<Message> getAllMessages() {
        return messages.values();
    }
}
