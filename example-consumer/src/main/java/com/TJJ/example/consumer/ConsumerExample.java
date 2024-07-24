package com.TJJ.example.consumer;

import com.TJJ.rpc.config.RpcConfig;
import com.TJJ.rpc.proxy.ServiceProxyFactory;
import com.TJJ.rpc.utils.ConfigUtils;
import com.tangtianj.example.common.model.User;
import com.tangtianj.example.common.service.UserService;

/**
 * 进行读取配置 扩展后的测试文件
 * 本文件是基于EasyConsumerExample文件开发的复杂RPC框架
 */
public class ConsumerExample {
    public static void main(String[] args) {

        UserService userService = ServiceProxyFactory.getProxy(UserService.class);
        User user = new User();
        user.setName("tianjunjie1");
        User user1 = userService.getUser(user);
        if (user1 != null) {
            System.out.println(user1.getName());
        } else {
            System.out.println("user==null");
        }
        //当mock=false时，不要调用模拟接口
//        short num = userService.getNum();
//        System.out.println(num);
//
//        char aChar = userService.getChar();
//        System.out.println(aChar);

    }
}
