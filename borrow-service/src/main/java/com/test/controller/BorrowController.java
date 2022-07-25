package com.test.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.test.entity.UserBorrowDetail;
import com.test.service.BorrowService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Collections;

@RestController
@RequestMapping("/borrow")
public class BorrowController {

    @Resource
    BorrowService service;

    @HystrixCommand(fallbackMethod = "onError")
    @GetMapping("/{uid}")
    public UserBorrowDetail findUserBorrowDetail(@PathVariable("uid") int uid) {
        return service.getUserBorrowDetailByUid(uid);
    }

    //备选方案
    UserBorrowDetail onError(int uid) {
        return new UserBorrowDetail(null, Collections.emptyList());
    }
}
