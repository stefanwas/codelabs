package com.stefan.training.vertx.lab2;

import io.vertx.core.Vertx;

public class VertxApp {
    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();

        vertx.deployVerticle(new EventBusReceiverVerticle("R1"));
        vertx.deployVerticle(new EventBusReceiverVerticle("R2"));

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        vertx.deployVerticle(new EventBusSenderVerticle());
    }
}
