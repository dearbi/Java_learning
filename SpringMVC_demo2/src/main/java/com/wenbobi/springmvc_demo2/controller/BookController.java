package com.wenbobi.springmvc_demo2.controller;

import com.wenbobi.springmvc_demo2.dao.BookDao;
import com.wenbobi.springmvc_demo2.model.BookInfo;
import com.wenbobi.springmvc_demo2.service.BookService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/book")
public class BookController {

    @RequestMapping("/getList")
    public List<BookInfo> getList(){
        //mock 数据
        BookService bookService=new BookService();
        return bookService.getList();
    }
}
