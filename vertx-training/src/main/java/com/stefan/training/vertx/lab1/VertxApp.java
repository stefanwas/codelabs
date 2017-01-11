package com.stefan.training.vertx.lab1;

import io.vertx.core.Vertx;

public class VertxApp {
    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        System.out.println("Vertex initiated.");
        MyVerticle verticle = new MyVerticle();
        vertx.deployVerticle(verticle);
        sleep();
        vertx.undeploy(verticle.deploymentID());
        sleep();
        System.out.println("App finished.");
        return;
    }

    private static void sleep() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
