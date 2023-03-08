package com.example.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.blog.pojo.UserInfo;
import com.example.blog.service.UserInfoService;
import com.example.blog.mapper.UserInfoMapper;
import org.springframework.stereotype.Service;

/**
* @author 东莞呵呵
* @description 针对表【tb_user_info】的数据库操作Service实现
* @createDate 2023-03-06 23:04:17
*/
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo>
    implements UserInfoService{

}




