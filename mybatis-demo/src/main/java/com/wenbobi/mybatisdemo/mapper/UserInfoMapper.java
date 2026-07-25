package com.wenbobi.mybatisdemo.mapper;

import com.wenbobi.mybatisdemo.model.UserInfo;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserInfoMapper {
    //这是
    @Select("SELECT * from `user_info`")
    List<UserInfo> getList();


    @Select("SELECT * from user_info where id = #{id}")
    UserInfo getUserInfoById(Integer id);


    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("INSERT INTO `user_info` (`username`, `password`, `age`) VALUES (#{username}, #{password}, #{age})")
    Integer insert(UserInfo userInfo);


    @Delete("DELETE FROM `user_info` WHERE `id` = #{id}")
    Integer deleteById(Integer id);

    @Update("UPDATE `user_info` SET `username` = #{username} WHERE `id` = #{id}")
    Integer update(UserInfo userInfo);


}
