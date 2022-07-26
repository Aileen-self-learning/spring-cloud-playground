package com.test.controller;

import com.test.entity.UserBorrowDetail;
import com.test.service.BorrowService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
@RestController
@RequestMapping("/borrow")
public class BorrowController {

    @Resource
    BorrowService service;

    @GetMapping("/{uid}")
    public UserBorrowDetail findUserBorrowDetail(@PathVariable("uid") int uid) {
        return service.getUserBorrowDetailByUid(uid);
    }
}
