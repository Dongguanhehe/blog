package com.example.blog.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.blog.dto.Result;
import com.example.blog.pojo.Blog;
import com.example.blog.service.BlogService;
import com.example.blog.util.RedisUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import static com.example.blog.util.RedisConstants.BLOG_CACHE_KEY;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date:2023-03-08
 * Time:21:03
 *
 * @Author: 东莞呵呵
 */
@RestController
@RequestMapping("/blog")
public class BlogController {

    @Resource
    BlogService blogService;
    @Resource
    RedisUtils redisUtils;

    @GetMapping("/page/{current}/{pageSize}")
    public Result selectByPage(@PathVariable Integer current,@PathVariable Integer pageSize){
        if(current<=0||pageSize<=0){
            return Result.fail("参数不合法");
        }
        Page<Blog> page=new Page<>(current,pageSize);
        return Result.ok(page);
    }

    @PostMapping("save")
    public Result saveBlog(@RequestBody Blog blog){
        blogService.save(blog);
        return Result.ok();
    }

    @GetMapping("/info/{id}")
    public Result blogInfo(@PathVariable Long id){
        Blog blog = redisUtils.setCache(BLOG_CACHE_KEY, id, Blog.class, blogId -> blogService.getById(blogId));
        return Result.ok(blog);
    }

    @DeleteMapping("/delete/{id}")
    public Result deleteBlog(@PathVariable Long id){
        boolean b = blogService.removeById(id);

        return b?Result.ok():Result.fail("删除失败");
    }


}
