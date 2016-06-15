package com.stefan.spring.web.training;

import java.util.Collection;

public class MessageController {

    private final MessageRepository repository;

    public MessageController(MessageRepository repository) {
        this.repository = repository;
    }

    public Message getMessageById(String id) {
        Message message = this.repository.getMessageById(id);
        return message;
    }

    public Collection<Message> getAllMessages() {
        Collection<Message> messages = this.repository.getAllMessages();
        return messages;
    }

}
