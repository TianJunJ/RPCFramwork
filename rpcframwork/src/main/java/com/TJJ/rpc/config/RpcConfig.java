package com.TJJ.rpc.config;

import com.TJJ.rpc.serializer.SerializerKeys;
import lombok.Data;

/**
 * 声明了默认值
 */
@Data
public class RpcConfig {

    /**
     * 名称
     */
    private String name = "tianJunJ-rpc";

    /**
     * 版本号
     */
    private String version = "3.1";

    /**
     * 角色(生产者或者是消费者)
     */
    private String role;

    /**
     * 服务器主机名
     */
    private String serverHost = "localhost";

    /**
     * 服务器端口
     */
    private Integer serverPort = 8087;

    /**
     * 是否调用模拟接口
     */
    private Boolean mock = false;

    /**
     * 序列化器配置
     */
    private String serializer = SerializerKeys.JDK;

    /**
     * 注册中心配置
     */
    private RegistryConfig registryConfig = new RegistryConfig();



}
