package com.example.blog.mapper;

import com.example.blog.pojo.BlogType;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 东莞呵呵
* @description 针对表【tb_blog_type】的数据库操作Mapper
* @createDate 2023-03-06 23:03:57
* @Entity com.example.blog.pojo.BlogType
*/
@Mapper
public interface BlogTypeMapper extends BaseMapper<BlogType> {

}




