package com.stefan.training.vertx.lab2;

import io.vertx.core.*;

public class EventBusSenderVerticle extends AbstractVerticle {
//    @Override
//    public Vertx getVertx() {
//        return vertx;
//    }

//    @Override
//    public void init(Vertx vertx, Context context) {
//
//    }

    @Override
    public void start(Future<Void> startFuture) throws Exception {
        vertx.eventBus().publish("anAddress", "message 1");
        vertx.eventBus().send("anAddress", "message 2");
    }

//    @Override
//    public void stop(Future<Void> stopFuture) throws Exception {
//
//    }
}
