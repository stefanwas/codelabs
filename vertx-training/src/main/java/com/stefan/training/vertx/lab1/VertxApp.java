package com.stefan.training.vertx.lab1;

import io.vertx.core.Vertx;

public class VertxApp {
    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        MyVerticle verticle = new MyVerticle();
        vertx.deployVerticle(verticle);
        vertx.undeploy(verticle.deploymentID());
//        vertx.close();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return;
    }
}
