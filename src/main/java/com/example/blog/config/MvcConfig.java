package com.example.blog.config;

import com.example.blog.util.LoginInterrupt;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Resource
    LoginInterrupt loginInterrupt;

    String[] excludePatterns = new String[]{"/swagger-resources/**",
            "/webjars/**",
            "/v2/**",
            "/swagger-ui.html/**",
            "/api",
            "/api-docs",
            "/api-docs/**",
            "/doc.html/**",
            "/shop/**",
//                        "/voucher/**",
//                        "/shop-type/**",
//                        "/upload/**",
//                        "/blog/hot",
            "/user/code",
            "/user/login/email"};
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterrupt)
                //拦截所有的URL
                .addPathPatterns("/**")
                .excludePathPatterns(
                        excludePatterns
                );
    }
}