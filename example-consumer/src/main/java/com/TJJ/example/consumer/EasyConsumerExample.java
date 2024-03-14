package com.TJJ.example.consumer;

import com.TJJ.rpc.proxy.ServiceProxyFactory;
import com.tangtianj.example.common.model.User;
import com.tangtianj.example.common.service.UserService;

public class EasyConsumerExample {
    public static void main(String[] args) {
        //静态代理
        UserService userService = new UserServiceProxy();
        //动态代理
        //UserService userService = ServiceProxyFactory.getProxy(UserService.class);
        User user = new User();
        user.setName("TianJunJ");
        User newUser = userService.getUser(user);
        if (newUser != null) {
            System.out.println(newUser.getName());
        } else {
            System.out.println("user==null");
        }
    }
}
