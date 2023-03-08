package com.example.blog.mapper;

import com.example.blog.pojo.Follow;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 东莞呵呵
* @description 针对表【tb_follow】的数据库操作Mapper
* @createDate 2023-03-06 23:04:08
* @Entity com.example.blog.pojo.Follow
*/
@Mapper
public interface FollowMapper extends BaseMapper<Follow> {

}




