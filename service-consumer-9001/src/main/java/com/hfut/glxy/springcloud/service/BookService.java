package com.hfut.glxy.springcloud.service;

import com.hfut.glxy.springcloud.entities.Book;
import com.hfut.glxy.springcloud.service.impl.BookServiceFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Component
@FeignClient(value = "SERVICE-PROVIDER", fallback = BookServiceFallBack.class)
public interface BookService {

    @RequestMapping("/")
    List<Book> getBookList();

    @RequestMapping("/updateBook")
    void updateBook(@RequestBody Book book);

    @RequestMapping("/deleteBook")
    void deleteBook(Integer id) ;

    @RequestMapping("/addBook")
    String addBook(@RequestBody Book book);
}
