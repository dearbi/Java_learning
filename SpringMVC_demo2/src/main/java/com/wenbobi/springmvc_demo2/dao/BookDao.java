package com.wenbobi.springmvc_demo2.dao;

import com.wenbobi.springmvc_demo2.model.BookInfo;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Component
public class BookDao {
    public List<BookInfo> mockBookData() {
        List<BookInfo> bookInfos=new ArrayList<>(15);
        for(int i=1;i<=15;i++){
            BookInfo bookInfo=new BookInfo();
            bookInfo.setId(i);
            bookInfo.setBookName("图书"+i);
            bookInfo.setAuthor("作者"+i);
            bookInfo.setCount(new Random().nextInt(100));
            bookInfo.setPrice(new BigDecimal(new Random().nextInt(100)));
            bookInfo.setPublish("出版社"+i);
            bookInfo.setStatus(i%5==0?2:1);
            bookInfo.setCreateTime(new Date());
            bookInfo.setUpdateTime(new Date());
            bookInfos.add(bookInfo);
        }
        return bookInfos;
    }
}
