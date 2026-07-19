package com.wenbobi.springmvc_demo2.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class BookInfo {
    //图书ID
    private Integer id;
    //书名
    private String bookName;
    //作者
    private String author;
    //数量
    private Integer count;
    //定价
    private BigDecimal price;
    //出版社
    private String publish;
    //状态0⽆效1允许借阅2不允许借阅
    private Integer status;
    //状态中文
    private String statusCN;
    //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;
}
