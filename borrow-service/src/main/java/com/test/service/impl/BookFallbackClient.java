package com.test.service.impl;

import com.test.entity.Book;
import com.test.service.client.BookClient;
import org.springframework.stereotype.Component;

@Component
public class BookFallbackClient implements BookClient {
    @Override
    public Book findBookById(int bid) {
        return new Book();
    }
}
