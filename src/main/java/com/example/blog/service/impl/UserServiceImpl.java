package com.example.blog.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.blog.dto.LoginFormDTO;
import com.example.blog.dto.Result;
import com.example.blog.dto.UserDTO;
import com.example.blog.pojo.User;
import com.example.blog.service.UserService;
import com.example.blog.mapper.UserMapper;
import com.example.blog.util.RedisUtils;
import com.example.blog.util.SystemConstants;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static com.example.blog.util.RedisConstants.*;

/**
* @author 东莞呵呵
* @description 针对表【tb_user】的数据库操作Service实现
* @createDate 2023-03-06 22:46:48
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

    @Resource
    StringRedisTemplate stringRedisTemplate;

    @Resource
    RedisUtils redisUtils;

    @Override
    public Result loginByEmail(LoginFormDTO loginFormDTO) {
        // 校验验证码,从redis中取出key是手机号
        String cacheCode = stringRedisTemplate.opsForValue().get(LOGIN_CODE_KEY + loginFormDTO.getEmail());
        String code = loginFormDTO.getCode();
        if (!code.equals(cacheCode)) {
            //3、不一致的话报错
            return Result.fail("验证码错误");
        }

        //4、一致，根据邮箱查询用户
        User user = query().eq("email", loginFormDTO.getEmail()).one();
        //5、没有查询到用户
        if (user == null) {
            //6、创建新用户
            user = createUserByEmail(loginFormDTO.getEmail());
        }
        // 7、生成token作为key
        String token = UUID.randomUUID().toString();
        // 8、查询到用户，存到redis，并设置时长
        UserDTO userDTO = BeanUtil.copyProperties(user, UserDTO.class);
        String userJson= JSONUtil.toJsonStr(userDTO);
        String tokenKey=LOGIN_USER_KEY+token;
        redisUtils.setString(LOGIN_USER_KEY+token,userJson,LOGIN_TOKEN_TTL,TimeUnit.MINUTES);
        // 9、返回给用户token
        return Result.ok(token);
    }

    private User createUserByEmail(String email) {
        //1、跟据手机号创建用户
        User user = new User();
        user.setEmail(email);
        user.setNickName(SystemConstants.USER_NICK_NAME_PREFIX + RandomUtil.randomString(10));
        baseMapper.insert(user);
        return user;
    }

    @Override
    public Result sendCode(String email) {
        //1、生成验证码
        String code = RandomUtil.randomNumbers(6);
        //2、存入redis
        redisUtils.setString(LOGIN_CODE_KEY+email,code,LOGIN_CODE_TTL, TimeUnit.MINUTES);
        //todo 3、发送验证码
        System.out.println(code);

        return Result.ok();
    }
}




