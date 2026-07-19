package com.wenbobi.springmvc_demo2.service;

import com.wenbobi.springmvc_demo2.dao.BookDao;
import com.wenbobi.springmvc_demo2.model.BookInfo;

import java.util.List;

public class BookService {
    public List<BookInfo> getList(){
        BookDao bookDao=new BookDao();
        List<BookInfo> bookInfos=bookDao.mockBookData();
        for(BookInfo bookInfo:bookInfos){
            bookInfo.setStatusCN(bookInfo.getStatus()==1?"允许借阅":"不允许借阅");
        }
        return bookInfos;
    }
}
