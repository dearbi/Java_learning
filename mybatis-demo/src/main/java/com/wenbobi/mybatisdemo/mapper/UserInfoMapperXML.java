package com.wenbobi.mybatisdemo.mapper;

import com.wenbobi.mybatisdemo.model.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserInfoMapperXML {

    List<UserInfo> getList();


    UserInfo getUserInfoById(Integer id);



    Integer insert(UserInfo userInfo);
//
//
//    Integer deleteById(Integer id);
//
//
//    Integer update(UserInfo userInfo);

    Integer insertUserInfoByCondition(UserInfo userInfo);

    List<UserInfo> queryByCondition(UserInfo userInfo);


    Integer batchDelete(List<Integer> ids);

}
