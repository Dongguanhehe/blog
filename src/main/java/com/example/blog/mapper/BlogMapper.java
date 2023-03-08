package com.example.blog.mapper;

import com.example.blog.pojo.Blog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 东莞呵呵
* @description 针对表【tb_blog】的数据库操作Mapper
* @createDate 2023-03-06 23:02:46
* @Entity com.example.blog.pojo.Blog
*/
@Mapper
public interface BlogMapper extends BaseMapper<Blog> {

}




