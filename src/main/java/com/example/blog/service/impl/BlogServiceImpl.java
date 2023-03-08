package com.example.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.blog.dto.Result;
import com.example.blog.pojo.Blog;
import com.example.blog.service.BlogService;
import com.example.blog.mapper.BlogMapper;
import org.springframework.stereotype.Service;

/**
* @author 东莞呵呵
* @description 针对表【tb_blog】的数据库操作Service实现
* @createDate 2023-03-06 23:02:46
*/
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog>
    implements BlogService{

}




