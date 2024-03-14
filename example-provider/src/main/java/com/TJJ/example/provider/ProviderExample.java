package com.TJJ.example.provider;

import com.TJJ.rpc.RpcApplication;
import com.TJJ.rpc.registry.LocalRegistry;
import com.TJJ.rpc.server.HttpServer;
import com.TJJ.rpc.server.VertxHttpServer;
import com.tangtianj.example.common.service.UserService;
//扩展读取配置文件后的 provider
public class ProviderExample {
    public static void main(String[] args) {
        //框架初始化
        RpcApplication.init();
        //注册服务
        LocalRegistry.register(UserService.class.getName(),UserServiceImpl.class);
        //提供服务
        HttpServer httpServer = new VertxHttpServer();
        httpServer.doStart(8083);
    }

}
