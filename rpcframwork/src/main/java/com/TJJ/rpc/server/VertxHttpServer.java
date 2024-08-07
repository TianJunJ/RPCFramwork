package com.TJJ.rpc.server;

import io.vertx.core.Vertx;

public class VertxHttpServer implements HttpServer {

    @Override
    public void doStart(int port) {
        Vertx vertx = Vertx.vertx();

        io.vertx.core.http.HttpServer httpServer = vertx.createHttpServer();

        //当前仅当有请求发送给前端时，才会调用这个函数
        httpServer.requestHandler(new HttpServerHandler());


        httpServer.listen(port,result->{
            if(result.succeeded()){
                System.out.println("Server is now listening on port： "+port);
            }else {
                System.out.println("Failed to start server"+result.cause());
            }
        });

    }
}
