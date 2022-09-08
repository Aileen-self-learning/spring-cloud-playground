package com.test.controller;

import com.test.entity.Book;
import com.test.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/book")
@Slf4j
public class BookController {

    @Resource
    BookService service;

    @GetMapping("/{bid}")
    public Book findBookById(@PathVariable("bid") int bid) {
        SecurityContext context = SecurityContextHolder.getContext();
        log.info("user info: {}", context.getAuthentication());
        return service.findBookById(bid);
    }
}
