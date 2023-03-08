package com.example.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.blog.pojo.BlogComments;
import com.example.blog.service.BlogCommentsService;
import com.example.blog.mapper.BlogCommentsMapper;
import org.springframework.stereotype.Service;

/**
* @author 东莞呵呵
* @description 针对表【tb_blog_comments】的数据库操作Service实现
* @createDate 2023-03-06 23:03:46
*/
@Service
public class BlogCommentsServiceImpl extends ServiceImpl<BlogCommentsMapper, BlogComments>
    implements BlogCommentsService{

}




