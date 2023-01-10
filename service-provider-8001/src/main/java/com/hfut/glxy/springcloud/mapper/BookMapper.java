package com.hfut.glxy.springcloud.mapper;

import com.hfut.glxy.springcloud.entities.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BookMapper {

    //查询所有图书
    List<Book> getBookList();

    //根据id查询图书
    Book getBook(@Param("id") Integer id);

    //更新图书
    void updateBook(@Param("book") Book book);

    //删除图书
    void deleteBook(@Param("id") Integer id);

    //添加图书
    void addBook(@Param("book") Book book);

    //根据书名查询图书
    Book getBookByName(@Param("bookName") String bookName);
}
