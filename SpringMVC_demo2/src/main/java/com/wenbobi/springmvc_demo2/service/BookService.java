package com.wenbobi.springmvc_demo2.service;

import com.sun.source.tree.LambdaExpressionTree;
import com.wenbobi.springmvc_demo2.dao.BookDao;
import com.wenbobi.springmvc_demo2.enums.BookStatus;
import com.wenbobi.springmvc_demo2.mapper.BookInfoMapper;
import com.wenbobi.springmvc_demo2.model.BookInfo;
import com.wenbobi.springmvc_demo2.model.PageRequest;
import com.wenbobi.springmvc_demo2.model.PageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookDao bookDao;

    public List<BookInfo> getList() {
//        BookDao bookDao=new BookDao();
        List<BookInfo> bookInfos = bookDao.mockBookData();
        for (BookInfo bookInfo : bookInfos) {
            bookInfo.setStatusCN(bookInfo.getStatus() == 1 ? "允许借阅" : "不允许借阅");
        }
        return bookInfos;
    }

    @Autowired
    private BookInfoMapper bookInfoMapper;

    public void addBook(BookInfo bookInfo) {
        bookInfoMapper.addBook(bookInfo);
    }

    public PageResponse<BookInfo> getListByPage(PageRequest pageRequest) {
        //查询图书总数
        Integer count = bookInfoMapper.count();
        if (count == 0) {
            return new PageResponse<>(count);
        }

        //查询当前页数据
        List<BookInfo> bookInfos = bookInfoMapper.getListByPage(pageRequest);
        for(BookInfo bookInfo:bookInfos){
            bookInfo.setStatusCN(BookStatus.getNameByCode(bookInfo.getStatus()).getName());
        }
        return new PageResponse<>(count, bookInfos);
    }
}
