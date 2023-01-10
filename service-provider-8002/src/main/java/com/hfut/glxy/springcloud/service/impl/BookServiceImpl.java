package com.hfut.glxy.springcloud.service.impl;

import com.hfut.glxy.springcloud.entities.Book;
import com.hfut.glxy.springcloud.mapper.BookMapper;
import com.hfut.glxy.springcloud.service.BookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Resource
    private BookMapper bookMapper;

    @Override
    public List<Book> getBookList() {
        List<Book> bookList = bookMapper.getBookList();
        return bookList;
    }

    @Override
    public Book getBook(Integer id) {
        Book book = bookMapper.getBook(id);
        return book;
    }

    @Override
    public void updateBook(Book book) {
        bookMapper.updateBook(book);
    }

    @Override
    public void deleteBook(Integer id) {
        bookMapper.deleteBook(id);
    }

    /**
     * 添加图书
     * @param book
     * @return
     */
    @Override
    public String addBook(Book book) {
        //首先根据书名查询图书是否已存在
        Book bookExist = bookMapper.getBookByName(book.getBookName());
        //若存在
        if (bookExist != null ) {
            //且图书状态为 0(已存在)
            if (bookExist.getBookStatus() == 0){
                //则返回“图书已存在”
                return "图书已存在";

            //若图书状态为 1(已删除)
            }else {
                //则更让新图书
                book.setId(bookExist.getId());
                bookMapper.updateBook(book);
                return "添加成功";
            }
        } else {
            //否则添加图书
            bookMapper.addBook(book);
            return "添加成功";
        }
    }
}
