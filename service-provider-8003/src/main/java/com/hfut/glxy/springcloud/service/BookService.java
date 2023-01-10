package com.hfut.glxy.springcloud.service;


import com.hfut.glxy.springcloud.entities.Book;

import java.util.List;

public interface BookService {

    //查询所有图书
    List<Book> getBookList();

    //根据id查询图书
    Book getBook(Integer id);

    //更新图书
    void updateBook(Book book);

    //删除图书
    void deleteBook(Integer id);

    //添加图书
    String addBook(Book book);
}
