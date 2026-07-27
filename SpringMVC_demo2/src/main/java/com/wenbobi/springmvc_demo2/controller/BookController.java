package com.wenbobi.springmvc_demo2.controller;

import ch.qos.logback.core.util.StringUtil;
import com.wenbobi.springmvc_demo2.dao.BookDao;
import com.wenbobi.springmvc_demo2.model.BookInfo;
import com.wenbobi.springmvc_demo2.model.PageRequest;
import com.wenbobi.springmvc_demo2.model.PageResponse;
import com.wenbobi.springmvc_demo2.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Slf4j
@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping("/getList")
    public List<BookInfo> getList() {
        //mock 数据

        return bookService.getList();
    }

    @RequestMapping("/getPageList")
    public PageResponse<BookInfo> getPageList(PageRequest pageRequest) {
        log.info("查询图书列表,pageRequest={}", pageRequest);
        PageResponse<BookInfo> response = bookService.getListByPage(pageRequest);
        return response;
    }


    @PostMapping("/addBook")
    public String addBook(BookInfo bookInfo) {
        log.info("添加图书，bookInfo={}", bookInfo);
        if (!StringUtils.hasText(bookInfo.getBookName())
                || !StringUtils.hasText(bookInfo.getAuthor())
                || bookInfo.getCount() == null
                || bookInfo.getPrice() == null
                || !StringUtils.hasText(bookInfo.getPublish())
                || bookInfo.getStatus() == null) {
            return "输入参数不合法，请检查入参";
        }
        try {
            bookService.addBook(bookInfo);
        } catch (Exception e) {
            log.error("添加图书失败，e:", e);
            return "添加图书失败";
        }
        return "success";
    }
}
