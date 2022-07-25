package com.test.service.client;

import com.test.entity.Book;
import com.test.service.impl.BookFallbackClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "bookService", fallback = BookFallbackClient.class)
public interface BookClient {

    @GetMapping("/book/{bid}")
    Book findBookById(@PathVariable("bid") int bid);
}
