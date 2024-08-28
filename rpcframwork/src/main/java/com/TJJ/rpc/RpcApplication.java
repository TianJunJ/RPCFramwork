package com.TJJ.rpc;

import com.TJJ.rpc.config.RegistryConfig;
import com.TJJ.rpc.config.RpcConfig;
import com.TJJ.rpc.constant.RpcConstant;
import com.TJJ.rpc.registry.Registry;
import com.TJJ.rpc.registry.RegistryFactory;
import com.TJJ.rpc.utils.ConfigUtils;
import lombok.extern.slf4j.Slf4j;

/**
 * RPC框架应用(该对象为单例）
 * 存放了项目全局用到的变量。双检锁单例模式实现
 * 加载配置：
 * RpcConfig rpc = RpcApplication.getRpcConfig();
 */
@Slf4j
public class RpcApplication {
    private static volatile RpcConfig rpcConfig;

    /**
     * 框架初始化，支持传入自定义配置
     *
     * @param newRpcConfig
     */
    public static void init(RpcConfig newRpcConfig) {
        rpcConfig = newRpcConfig;
        log.info("rpc-framework start init,config={}", newRpcConfig.toString());
        //注册中心初始化
        RegistryConfig registryConfig = rpcConfig.getRegistryConfig();
        Registry registry = RegistryFactory.getInstance(registryConfig.getRegistry());
        registry.init(registryConfig);
        log.info("registry init, config = {}", registryConfig);

        //创建并注册 JVM的shutdown hook，JVM退出时执行相关操作
        //尽在生产者中执行
        if("provider".equalsIgnoreCase(rpcConfig.getRole())){
            Runtime.getRuntime().addShutdownHook(new Thread(registry::destroy));
        }
    }

    /**
     * 初始化，使用默认配置
     */

    public static void init() {
        RpcConfig defaultRpcConfig;
        try {
            //先读取代码中的默认配置
            defaultRpcConfig = ConfigUtils.loadConfig(RpcConfig.class, RpcConstant.DEFAULT_CONFIG_PREFIX);
        } catch (Exception e) {
            //配置失败，使用默认值
            defaultRpcConfig = new RpcConfig();
        }
        init(defaultRpcConfig);
    }

    /**
     * 获取配置,使用双检锁来实现单例生成
     *
     * @return
     */
    public static RpcConfig getRpcConfig() {
        if (rpcConfig == null) {
            synchronized (RpcApplication.class) {
                if (rpcConfig == null) {
                    init();
                }
            }
        }
        return rpcConfig;
    }


}
