package com.TJJ.example.provider;


import com.TJJ.rpc.registry.LocalRegistry;
import com.TJJ.rpc.server.HttpServer;
import com.TJJ.rpc.server.VertxHttpServer;
import com.tangtianj.example.common.service.UserService;

public class EasyProviderExample {
    public static void main(String[] args) {
        //注册服务
        LocalRegistry.register(UserService.class.getName(),UserServiceImpl.class);
        //提供服务
        HttpServer httpServer = new VertxHttpServer();
        httpServer.doStart(8083);
    }
}
