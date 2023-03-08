package com.example.blog.util;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.example.blog.dto.UserDTO;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import static com.example.blog.util.RedisConstants.LOGIN_TOKEN_TTL;
import static com.example.blog.util.RedisConstants.LOGIN_USER_KEY;


@Component
public class LoginInterrupt implements HandlerInterceptor {
    @Resource
    StringRedisTemplate stringRedisTemplate;
    @Resource
    RedisUtils redisUtils;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 1.获取请求头中的token
        String token = request.getHeader("authorization");
        if (StrUtil.isBlank(token)) {
            return false;
        }
        // 2.基于TOKEN获取redis中的用户
        String key = LOGIN_USER_KEY + token;
        UserDTO userDTO = redisUtils.getBean(key, UserDTO.class);
        // 3.判断用户是否存在
        if (userDTO == null) {
            return false;
        }
        // 存在，保存用户信息到 ThreadLocal
        UserHolder.saveUser(userDTO);
        // 刷新token有效期
        stringRedisTemplate.expire(key, LOGIN_TOKEN_TTL, TimeUnit.MINUTES);
        // 放行
        return true;
    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        UserHolder.removeUser();
    }
}