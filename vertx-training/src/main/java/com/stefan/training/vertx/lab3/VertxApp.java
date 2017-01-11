package com.stefan.training.vertx.lab3;

import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.core.http.HttpServerResponse;

public class VertxApp {
    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        HttpServer httpServer = vertx.createHttpServer();
        httpServer.requestHandler(new Handler<HttpServerRequest>() {
            int reqCounter = 0;
            @Override
            public void handle(HttpServerRequest request) {
                System.out.println("Handling incoming request(" + ++reqCounter +")! [Thread:" + Thread.currentThread().getName() +"]");

                String content = "Vert.x is alive!";

                HttpServerResponse response = request.response();
                response.setStatusCode(200);
                response.headers()
                        .add("Content-Length", String.valueOf(content.getBytes().length)) // this size is important
                        .add("Content-Type", "text/html")
                        .add("Connection", "keep-alive close");
                response.write(content);
                response.end();
//                response.close(); <-- this closes TCP connection
            }
        });
        httpServer.listen(8080);
        // wait some time
        sleep();
//        httpServer.close();
        System.out.println("App closed.");
//        vertx.eventBus().
    }

    private static void sleep() {
        try {
            System.out.println("Waiting...");
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
