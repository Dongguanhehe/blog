package com.example.blog.service;

import com.example.blog.dto.LoginFormDTO;
import com.example.blog.dto.Result;
import com.example.blog.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 东莞呵呵
* @description 针对表【tb_user】的数据库操作Service
* @createDate 2023-03-06 22:46:48
*/
public interface UserService extends IService<User> {

    Result loginByEmail(LoginFormDTO loginFormDTO);

    Result sendCode(String email);
}
