package com.stefan.training.vertx.lab2;

import io.vertx.core.Vertx;

public class VertxApp {
    public static void main(String[] args) {

        System.out.println("Main thread: " + Thread.currentThread().getName());

        Vertx vertx = Vertx.vertx();

        vertx.deployVerticle(new EventBusReceiverVerticle("R1"));
        vertx.deployVerticle(new EventBusReceiverVerticle("R2"));

        sleep();

        vertx.deployVerticle(new EventBusSenderVerticle());
    }

    private static void sleep() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
