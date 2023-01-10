package com.hfut.glxy.springcloud.service.impl;

import com.hfut.glxy.springcloud.entities.Book;
import com.hfut.glxy.springcloud.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class BookServiceFallBack implements BookService {

    @Override
    public List<Book> getBookList() {
        log.info("服务降级！！！！！！");
        List<Book> list = new ArrayList<Book>();
        return list;
    }

    @Override
    public void updateBook(Book book) {
        log.info("服务降级！！！！！！");
    }

    @Override
    public void deleteBook(Integer id) {
        log.info("服务降级！！！！！！");
    }

    @Override
    public String addBook(Book book) {
        log.info("服务降级！！！！！！");
        return "服务降级！！！！！！";
    }
}
