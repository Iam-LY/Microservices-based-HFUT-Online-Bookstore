package com.hfut.glxy.springcloud.controller;

import com.hfut.glxy.springcloud.entities.Book;
import com.hfut.glxy.springcloud.service.BookService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class BookController {

    @Resource
    private BookService bookService;

    /**
     * 查询所有图书
     * @return
     */
    @RequestMapping("/")
    public List<Book> getBookList() {
        List<Book> bookList = bookService.getBookList();
        return bookList;
    }

    /**
     * 更新图书信息
     * @param book
     */
    @RequestMapping("/updateBook")
    public void updateBook(@RequestBody Book book) {
        bookService.updateBook(book);
    }

    /**
     * 根据图书id删除图书（逻辑删除，即将图书的状态改成 1 ）
     * @param id
     */
    @RequestMapping("/deleteBook")
    public void deleteBook(@RequestBody Integer id) {
        bookService.deleteBook(id);
    }

    /**
     * 添加图书
     * @param book
     * @return
     */
    @RequestMapping("/addBook")
    public String addBook(@RequestBody Book book) {
        String addBook = bookService.addBook(book);
        return addBook;
    }
}
