package com.test.service.client;

import com.test.entity.User;
import com.test.service.impl.UserFallbackClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "userService", fallback = UserFallbackClient.class)
public interface UserClient {

    @GetMapping("/user/{uuid}")
    User findUserById(@PathVariable("uuid") int uuid);
}
