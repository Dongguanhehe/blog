package com.example.blog.util;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date:2023-03-08
 * Time:16:32
 *
 * @Author: 东莞呵呵
 */
public class RedisConstants {
    public static final String LOGIN_CODE_KEY = "blog:login:code:";
    public static final Long LOGIN_CODE_TTL = 5L;
    public static final String LOGIN_USER_KEY = "blog:login:user:";
    public static final Long LOGIN_TOKEN_TTL = 60L;
    public static final Long CACHE_BLOG_TTL = 30L;
    public static final Long CACHE_NULL_TTL = 3L;

    public static final String BLOG_CACHE_KEY = "blog:cache:blogs:";
}
