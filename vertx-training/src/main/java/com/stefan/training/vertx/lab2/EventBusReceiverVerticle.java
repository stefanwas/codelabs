package com.stefan.training.vertx.lab2;

import io.vertx.core.*;
import io.vertx.core.eventbus.Message;

public class EventBusReceiverVerticle extends AbstractVerticle {

    private String name;

    public EventBusReceiverVerticle(String name) {
        this.name = name;
    }

    @Override
    public void start(Future<Void> startFuture) throws Exception {
        Handler<Message<String>> messageHandler = message -> {
            String threadName = message.body() + Thread.currentThread().getName();
            System.out.println(this.name + " received message: " + "[" + threadName + "]");
        };

        vertx.eventBus().consumer("anAddress", messageHandler);
    }

//    @Override
//    public void stop(Future<Void> stopFuture) throws Exception {
//
//    }
}
