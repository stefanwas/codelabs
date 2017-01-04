package com.stefan.training.vertx.lab1;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;

public class MyVerticle extends AbstractVerticle {

    @Override
    public void start(Future<Void> startFuture) {

//        vertx.eventBus().consumer("address", message -> {
//            System.out.println("1 received message.body() = "  + message.body());
//        });


        System.out.println("MyVerticle started!");


    }

    @Override
    public void stop(Future stopFuture) throws Exception {
        System.out.println("MyVerticle stopped!");
    }
}
