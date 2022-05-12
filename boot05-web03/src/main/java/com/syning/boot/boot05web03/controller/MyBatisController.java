package com.syning.boot.boot05web03.controller;

import com.syning.boot.boot05web03.entity.Book;
import com.syning.boot.boot05web03.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MyBatisController {

    @Autowired
    private BookService bookService;

    @ResponseBody
    @GetMapping(value = "/booklist")
    public Map<String, Object> retBook() {

        Map<String, Object> map = new HashMap<>();

        List<Book> list = bookService.getBookList();

        map.put("booklist", list);

        return map;
    }



    @ResponseBody
    @GetMapping(value = "/bookById")
    public Book getBookById(@RequestParam("id") Integer id) {
        return bookService.getBookById(id);
    }





}
