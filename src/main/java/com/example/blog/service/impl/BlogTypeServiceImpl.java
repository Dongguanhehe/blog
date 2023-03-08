package com.example.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.blog.pojo.BlogType;
import com.example.blog.service.BlogTypeService;
import com.example.blog.mapper.BlogTypeMapper;
import org.springframework.stereotype.Service;

/**
* @author 东莞呵呵
* @description 针对表【tb_blog_type】的数据库操作Service实现
* @createDate 2023-03-06 23:03:57
*/
@Service
public class BlogTypeServiceImpl extends ServiceImpl<BlogTypeMapper, BlogType>
    implements BlogTypeService{

}




