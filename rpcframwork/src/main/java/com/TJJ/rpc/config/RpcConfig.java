package com.TJJ.rpc.config;

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
     * 服务器主机名
     */
    private String serverHost = "localhost";

    /**
     * 服务器端口
     */
    private Integer serverPort = 8087;

    /**
     *是否调用模拟接口
     */
    private Boolean mock = false;

}
