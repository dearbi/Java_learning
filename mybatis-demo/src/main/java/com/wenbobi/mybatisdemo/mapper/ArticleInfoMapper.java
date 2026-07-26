package com.wenbobi.mybatisdemo.mapper;

import com.wenbobi.mybatisdemo.model.ArticleInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ArticleInfoMapper {

    ArticleInfo getArticleInfoById(@Param("id") Integer id);
}
