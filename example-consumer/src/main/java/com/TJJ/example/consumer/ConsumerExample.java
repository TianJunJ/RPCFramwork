package com.TJJ.example.consumer;

import com.TJJ.rpc.config.RpcConfig;
import com.TJJ.rpc.utils.ConfigUtils;

/**
 * 进行读取配置 扩展后的测试文件
 */
public class ConsumerExample {
    public static void main(String[] args) {

        //测试消费者能否通过配置文件获取配置信息
        RpcConfig rpc = ConfigUtils.loadConfig(RpcConfig.class,"rpc");
        System.out.println(rpc);
    }
}
