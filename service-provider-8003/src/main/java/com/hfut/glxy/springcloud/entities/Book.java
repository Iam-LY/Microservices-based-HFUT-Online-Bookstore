package com.hfut.glxy.springcloud.entities;

import lombok.ToString;

@ToString
public class Book {
    private Integer id;
    private String bookImg;
    private String bookName;
    private Double price;
    private String author;
    private Integer saleCount;
    private Integer bookCount;
    private Integer bookStatus = 0;

    public Book() {
    }

    public Book(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getBookImg() {
        return bookImg;
    }

    public String getBookName() {
        return bookName;
    }

    public Double getPrice() {
        return price;
    }

    public String getAuthor() {
        return author;
    }

    public Integer getSaleCount() {
        return saleCount;
    }

    public Integer getBookCount() {
        return bookCount;
    }

    public Integer getBookStatus() {
        return bookStatus;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setBookImg(String bookImg) {
        this.bookImg = bookImg;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setSaleCount(Integer saleCount) {
        this.saleCount = saleCount;
    }

    public void setBookCount(Integer bookCount) {
        this.bookCount = bookCount;
    }

    public void setBookStatus(Integer bookStatus) {
        this.bookStatus = bookStatus;
    }
}
