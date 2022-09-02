package com.test.controller;

import com.test.entity.User;
import com.test.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserController {
    @Resource
    UserService service;

    @Value("${test.lb}")
    String lb;

    @GetMapping("/user/{uuid}")
    public User findUserById(@PathVariable("uuid") int uuid) {
        System.out.println("lb: " + lb);
        return service.getUserById(uuid);
    }
}
