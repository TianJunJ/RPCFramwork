package com.TJJ.example.provider;

import com.tangtianj.example.common.model.User;
import com.tangtianj.example.common.service.UserService;

public class UserServiceImpl implements UserService {
    public User getUser(User user) {
        System.out.println("用户名: " + user.getName());
        return user;
    }
}
