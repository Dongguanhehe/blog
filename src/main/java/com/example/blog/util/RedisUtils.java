package com.example.blog.util;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import static com.example.blog.util.RedisConstants.CACHE_BLOG_TTL;
import static com.example.blog.util.RedisConstants.CACHE_NULL_TTL;

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

    public <T,ID> T setCache(String keyPrefix, ID id, Class<T> tClass, Function<ID,T> function){
        String key = keyPrefix + id;
        // 1、从redis中查询缓存
        String Json = stringRedisTemplate.opsForValue().get("key");
        // 2、判断是否存在
        if (StrUtil.isNotBlank(Json)) {
            // 存在,直接返回
            return JSONUtil.toBean(Json, tClass);
        }
        //判断命中的值是否是空值
        if (Json != null) {
            //返回一个错误信息
            return null;
        }
        // 4.实现缓存重构
        T t = function.apply(id);
        // 5.不存在，返回错误
        if(t == null){
            //将空值写入redis
            stringRedisTemplate.opsForValue().set(key,"",CACHE_NULL_TTL+RandomUtil.randomLong(3),TimeUnit.MINUTES);
            //返回错误信息
            return null;
        }
        //6.写入redis
        stringRedisTemplate.opsForValue().set(key,JSONUtil.toJsonStr(t),CACHE_BLOG_TTL+ RandomUtil.randomLong(10),TimeUnit.MINUTES);

        return t;
    }
}
