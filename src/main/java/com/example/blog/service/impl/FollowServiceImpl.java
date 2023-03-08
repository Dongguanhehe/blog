package com.example.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.blog.pojo.Follow;
import com.example.blog.service.FollowService;
import com.example.blog.mapper.FollowMapper;
import org.springframework.stereotype.Service;

/**
* @author 东莞呵呵
* @description 针对表【tb_follow】的数据库操作Service实现
* @createDate 2023-03-06 23:04:08
*/
@Service
public class FollowServiceImpl extends ServiceImpl<FollowMapper, Follow>
    implements FollowService{

}




