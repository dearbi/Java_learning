package com.wenbobi.springmvc_demo2.mapper;

import com.wenbobi.springmvc_demo2.model.BookInfo;
import com.wenbobi.springmvc_demo2.model.PageRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BookInfoMapper {

    @Insert("insert into book_info (book_name, author, count, price, publish, status) values (#{bookName}, #{author}, #{count}, #{price}, #{publish}, #{status})")
    Integer addBook(BookInfo bookInfo);

    @Select("select count(1) from book_info where status<>0")
    Integer count();

    @Select("select * from book_info where status<>0 limit #{offset},#{pageSize}")
    List<BookInfo> getListByPage(PageRequest pageRequest);

    @Select("select * from book_info where id=#{bookId} and status<>0")
    BookInfo queryBookId(Integer bookId);


    Integer updateBook(BookInfo bookInfo);

    Integer batchDelete(@Param("ids") List<Integer> ids);
}
