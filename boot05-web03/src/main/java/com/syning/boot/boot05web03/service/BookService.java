package com.syning.boot.boot05web03.service;


import com.syning.boot.boot05web03.entity.Book;
import com.syning.boot.boot05web03.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {


    @Autowired
    BookMapper bookMapper;


    public List<Book> getBookList() {
        List<Book> list = bookMapper.getAllBook();

        return list;
    }


    public Book getBookById(Integer id) {
        return bookMapper.getBookById(id);
    }




}
