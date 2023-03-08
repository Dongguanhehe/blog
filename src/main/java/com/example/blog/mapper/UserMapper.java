package com.example.blog.mapper;

import com.example.blog.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 东莞呵呵
* @description 针对表【tb_user】的数据库操作Mapper
* @createDate 2023-03-06 22:46:48
* @Entity com.example.blog.pojo.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {

}




