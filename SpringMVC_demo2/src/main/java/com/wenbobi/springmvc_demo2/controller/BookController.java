package com.wenbobi.springmvc_demo2.controller;

import ch.qos.logback.core.util.StringUtil;
import com.wenbobi.springmvc_demo2.dao.BookDao;
import com.wenbobi.springmvc_demo2.enums.BookStatus;
import com.wenbobi.springmvc_demo2.enums.ResultCode;
import com.wenbobi.springmvc_demo2.model.*;
import com.wenbobi.springmvc_demo2.service.BookService;
import jakarta.servlet.http.HttpSession;
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

//    @RequestMapping("/getList")
//    public List<BookInfo> getList() {
//        //mock 数据
//
//        return bookService.getList();
//    }

    @RequestMapping("/getPageList")
    public Result<PageResponse<BookInfo>> getPageList(PageRequest pageRequest, HttpSession session) {
        UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
        if(userInfo==null||userInfo.getId()<1 ){
            log.info("用户未登录");
            Result result=new Result();
            result.setCode(ResultCode.UNLOGIN.getCode());
            result.setErrMsg("用户未登录");
            return result;
        }
        log.info("查询图书列表,pageRequest={}", pageRequest);
        PageResponse<BookInfo> response = bookService.getListByPage(pageRequest);
        Result result=new Result();
        result.setCode(ResultCode.SUCCESS.getCode());
        result.setErrMsg("success");
        result.setData(response);
        return ResultCode.success(response);
    }


    @PostMapping("/addBook")
    public Result<String> addBook(BookInfo bookInfo) {
        log.info("添加图书，bookInfo={}", bookInfo);
        if (!StringUtils.hasText(bookInfo.getBookName())
                || !StringUtils.hasText(bookInfo.getAuthor())
                || bookInfo.getCount() == null
                || bookInfo.getPrice() == null
                || !StringUtils.hasText(bookInfo.getPublish())
                || bookInfo.getStatus() == null) {
            return ResultCode.fail("输入参数不合法，请检查入参");
        }
        try {
            bookService.addBook(bookInfo);
        } catch (Exception e) {
            log.error("添加图书失败，e:", e);
            return ResultCode.fail("添加图书失败");
        }
        return ResultCode.success("success");
    }

    @RequestMapping("/queryBookId")
    public BookInfo queryBookId(Integer bookId) {
        log.info("查询图书状态，bookId={}", bookId);
        if(bookId == null || bookId < 1) {
            return new BookInfo();//返回一个空对象
        }
        BookInfo bookInfo = bookService.queryBookId(bookId);
        return bookInfo;
    }

    @PostMapping("/updateBook")
    public String updateBook(BookInfo bookInfo) {
        log.info("更新图书，bookInfo={}", bookInfo);
        if (bookInfo.getId() == null) {
            return "更新失败：图书ID不能为空";
        }
        try {
            Integer result = bookService.updateBook(bookInfo);
            if (result <= 0) {
                return "更新失败：未找到对应图书";
            }
        }catch (Exception e){
            log.error("更新图书失败，e:", e);
            return "更新图书失败";
        }
        return "success";
    }

    @PostMapping("/deleteBook")
    public String deleteBook(Integer bookId) {
        log.info("删除图书，bookId={}", bookId);
        if (bookId == null || bookId < 1) {
            return "删除失败：图书ID不能为空";
        }
        try {
            bookService.deleteBook(bookId);
        } catch (Exception e) {
            log.error("删除图书失败，e:", e);
            return "删除图书失败";
        }
        return "success";
    }

    @PostMapping("/batchDelete")
    public String batchDelete(String ids) {
        log.info("批量删除图书，ids={}", ids);
        if (!StringUtils.hasText(ids)) {
            return "删除失败：请选择要删除的图书";
        }
        try {
            List<Integer> idList = new ArrayList<>();
            for (String id : ids.split(",")) {
                idList.add(Integer.parseInt(id.trim()));
            }
            bookService.batchDelete(idList);
        } catch (Exception e) {
            log.error("批量删除失败，e:", e);
            return "批量删除失败";
        }
        return "success";
    }
}
