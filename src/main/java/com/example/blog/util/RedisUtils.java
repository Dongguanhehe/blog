package com.example.blog.util;

import cn.hutool.json.JSONUtil;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date:2023-03-08
 * Time:16:37
 *
 * @Author: 东莞呵呵
 */
@Component
public class RedisUtils {
    @Resource
    StringRedisTemplate stringRedisTemplate;

    public void setString(String key, Object val, Long ttl, TimeUnit unit){
        stringRedisTemplate.opsForValue().set(key, JSONUtil.toJsonStr(val));
        stringRedisTemplate.expire(key,ttl,unit);
    }

    public<T> T getBean(String key,Class<T> tClass){
        String json = stringRedisTemplate.opsForValue().get(key);
        T t = JSONUtil.toBean(json, tClass);
        return t;
    }
}
