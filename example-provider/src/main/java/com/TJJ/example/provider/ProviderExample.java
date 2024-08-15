package com.TJJ.example.provider;

import com.TJJ.rpc.RpcApplication;
import com.TJJ.rpc.config.RegistryConfig;
import com.TJJ.rpc.config.RpcConfig;
import com.TJJ.rpc.model.ServiceMetaInfo;
import com.TJJ.rpc.registry.LocalRegistry;
import com.TJJ.rpc.registry.Registry;
import com.TJJ.rpc.registry.RegistryFactory;
import com.TJJ.rpc.server.HttpServer;
import com.TJJ.rpc.server.VertxHttpServer;
import com.tangtianj.example.common.service.UserService;
/**
 * 扩展读取配置文件后的 provider
 * 本文件是基于EasyProviderExample文件开发的复杂RPC框架
 */
public class ProviderExample {
    public static void main(String[] args) {
        // RPC 框架初始化
        RpcApplication.init();

        // 注册服务
        String serviceName = UserService.class.getName();
        LocalRegistry.register(serviceName, UserServiceImpl.class);

        // 注册服务到注册中心
        RpcConfig rpcConfig = RpcApplication.getRpcConfig();
        RegistryConfig registryConfig = rpcConfig.getRegistryConfig();
        Registry registry = RegistryFactory.getInstance(registryConfig.getRegistry());
        ServiceMetaInfo serviceMetaInfo = new ServiceMetaInfo();
        serviceMetaInfo.setServiceName(serviceName);
        serviceMetaInfo.setServiceHost(rpcConfig.getServerHost());
        serviceMetaInfo.setServicePort(rpcConfig.getServerPort());
        try {
            registry.register(serviceMetaInfo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // 启动 web 服务
        HttpServer httpServer = new VertxHttpServer();
        httpServer.doStart(RpcApplication.getRpcConfig().getServerPort());
    }

}

