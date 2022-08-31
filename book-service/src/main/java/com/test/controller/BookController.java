package com.test.controller;

import com.test.entity.Book;
import com.test.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/book")
public class BookController {

    @Resource
    BookService service;

    @GetMapping("/{bid}")
    public Book findBookById(@PathVariable("bid") int bid) {
        System.out.println("Being called");
        return service.findBookById(bid);
    }
}
