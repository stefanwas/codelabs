package com.stefan.training.vertx.lab2;

import io.vertx.core.*;

public class EventBusSenderVerticle extends AbstractVerticle {
    @Override
    public Vertx getVertx() {
        return null;
    }

//    @Override
//    public void init(Vertx vertx, Context context) {
//
//    }

    @Override
    public void start(Future<Void> startFuture) throws Exception {
        vertx.eventBus().publish("anAddress", "message 2");
        vertx.eventBus().send   ("anAddress", "message 1");
    }

//    @Override
//    public void stop(Future<Void> stopFuture) throws Exception {
//
//    }
}
