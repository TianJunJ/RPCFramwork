package com.tangtianj.example.common.service;

import com.tangtianj.example.common.model.User;

public interface UserService {
    User getUser(User user);

    /**
     * 测试Mock接口是否能够与真实接口区分开
     * 下面都是模拟接口，真实的请求只有getUser，如果mock=false，请不要在消费者中调用模拟接口
     * @return
     */
    default short getNum() {
        return 1;
    }

    default char getChar() {
        return 'c';
    }

}
