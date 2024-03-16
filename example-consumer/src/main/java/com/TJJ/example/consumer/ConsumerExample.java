package com.TJJ.example.consumer;

import com.TJJ.rpc.config.RpcConfig;
import com.TJJ.rpc.proxy.ServiceProxyFactory;
import com.TJJ.rpc.utils.ConfigUtils;
import com.tangtianj.example.common.model.User;
import com.tangtianj.example.common.service.UserService;

/**
 * 进行读取配置 扩展后的测试文件
 */
public class ConsumerExample {
    public static void main(String[] args) {


        //测试消费者能否通过配置文件获取配置信息
//        RpcConfig rpc = ConfigUtils.loadConfig(RpcConfig.class,"rpc");
//        System.out.println(rpc);

        //测试Mock
        UserService userService = ServiceProxyFactory.getProxy(UserService.class);
        User user = new User();
        user.setName("tianjunjie1");
        User user1 = userService.getUser(user);
        if (user1 != null) {
            System.out.println(user1.getName());
        } else {
            System.out.println("user==null");
        }
        short num = userService.getNum();
        System.out.println(num);

        char aChar = userService.getChar();
        System.out.println(aChar);


    }
}
