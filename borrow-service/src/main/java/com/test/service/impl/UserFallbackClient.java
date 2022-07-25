package com.test.service.impl;

import com.test.entity.User;
import com.test.service.client.UserClient;
import org.springframework.stereotype.Component;

@Component
public class UserFallbackClient implements UserClient {
    @Override
    public User findUserById(int uuid) {
        User user = new User();
        user.setName("补救措施");
        return user;
    }
}
