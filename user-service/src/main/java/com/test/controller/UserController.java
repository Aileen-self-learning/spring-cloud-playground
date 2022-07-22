package com.test.controller;

import com.test.entity.User;
import com.test.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserController {

    @Resource
    UserService service;

    @GetMapping("/user/{uuid}")
    public User findUserById(@PathVariable("uuid") int uuid) {
        return service.getUserById(uuid);
    }
}
