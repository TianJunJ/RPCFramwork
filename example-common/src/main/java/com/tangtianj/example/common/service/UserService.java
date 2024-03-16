package com.tangtianj.example.common.service;

import com.tangtianj.example.common.model.User;

public interface UserService {
    User getUser(User user);

    /**
     * 测试Mock接口是否能够与真实接口区分开
     *
     * @return
     */
    default short getNum() {
        return 1;
    }

    default char getChar() {
        return 'c';
    }

}
