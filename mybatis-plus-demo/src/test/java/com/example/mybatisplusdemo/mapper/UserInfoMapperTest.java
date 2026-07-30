package com.example.mybatisplusdemo.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mybatisplusdemo.model.UserInfo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserInfoMapperTest {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Test
    void testInsert() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("test_user");
        userInfo.setPassword("123456");
        userInfo.setAge(25);
        userInfo.setGender(1);
        userInfo.setPhone("13800138000");
        userInfo.setDeleteFlag(0);
        int result = userInfoMapper.insert(userInfo);
        System.out.println("插入结果: " + result + "，插入的ID: " + userInfo.getId());
        assertEquals(1, result);
        assertNotNull(userInfo.getId());
    }

    @Test
    void testSelectById() {
        UserInfo userInfo = userInfoMapper.selectById(1);
        System.out.println("查询结果: " + userInfo);
        assertNotNull(userInfo);
    }

    @Test
    void testSelectList() {
        List<UserInfo> userList = userInfoMapper.selectList(null);
        System.out.println("查询列表结果: " + userList);
        assertNotNull(userList);
        System.out.println("记录总数: " + userList.size());
    }

    @Test
    void testUpdateById() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(1);
        userInfo.setUsername("updated_user");
        userInfo.setAge(30);
        int result = userInfoMapper.updateById(userInfo);
        System.out.println("更新结果: " + result);
        assertEquals(1, result);
    }

    @Test
    void testDeleteById() {
        int result = userInfoMapper.deleteById(1);
        System.out.println("删除结果: " + result);
        assertEquals(1, result);
    }

    @Test
    void testSelectByCondition() {
        LambdaQueryWrapper<UserInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(UserInfo::getGender, 1)
                   .gt(UserInfo::getAge, 18)
                   .eq(UserInfo::getDeleteFlag, 0);
        List<UserInfo> userList = userInfoMapper.selectList(queryWrapper);
        System.out.println("条件查询结果: " + userList);
        assertNotNull(userList);
    }

    @Test
    void testQueryByCondition() {
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id", "username", "age").eq("age", 17).like("username", "u");
        System.out.println(userInfoMapper.selectList(queryWrapper));
    }

}