package com.stefan.training.vertx.lab2;

import io.vertx.core.*;

public class EventBusSenderVerticle extends AbstractVerticle {

    @Override
    public void start(Future<Void> startFuture) throws Exception {
        System.out.println("Publisher thread: " + Thread.currentThread().getName());
        vertx.eventBus().publish("anAddress", "message 1 (for all)");
        vertx.eventBus().send("anAddress", "message 2 (for one)");
    }

//    @Override
//    public void stop(Future<Void> stopFuture) throws Exception {
//
//    }
}
