package com.stefan.training.vertx.lab2;

import io.vertx.core.*;

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
        vertx.eventBus().consumer("anAddress", message -> {
            System.out.println(this.name + " received message: " + message.body());
        });
    }

//    @Override
//    public void stop(Future<Void> stopFuture) throws Exception {
//
//    }
}
