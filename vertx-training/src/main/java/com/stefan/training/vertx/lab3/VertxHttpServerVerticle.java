package com.stefan.training.vertx.lab3;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpServer;

public class VertxHttpServerVerticle extends AbstractVerticle {

    private HttpServer httpServer = null;

    @Override
    public void start() throws Exception {
        httpServer = vertx.createHttpServer();
    }
}
