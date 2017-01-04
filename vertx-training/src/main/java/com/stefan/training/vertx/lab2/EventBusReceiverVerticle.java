package com.stefan.training.vertx.lab2;

import io.vertx.core.*;
import io.vertx.core.eventbus.Message;

public class EventBusReceiverVerticle extends AbstractVerticle {

    private String name;

    public EventBusReceiverVerticle(String name) {
        this.name = name;
    }

//    @Override
//    public Vertx getVertx() {
//        return null;
//    }
//
//    @Override
//    public void init(Vertx vertx, Context context) {
//
//    }

    @Override
    public void start(Future<Void> startFuture) throws Exception {
        Handler<Message<String>> messageHandler = message -> {
            System.out.println(this.name + " received message: " + message.body());
        };

        vertx.eventBus().consumer("anAddress", messageHandler);
    }

//    @Override
//    public void stop(Future<Void> stopFuture) throws Exception {
//
//    }
}
