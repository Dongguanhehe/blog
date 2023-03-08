package com.example.blog.controller;

import com.example.blog.dto.LoginFormDTO;
import com.example.blog.dto.Result;
import com.example.blog.dto.UserDTO;
import com.example.blog.service.UserService;
import com.example.blog.util.UserHolder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date:2023-03-08
 * Time:16:18
 *
 * @Author: 东莞呵呵
 */
@Api(value = "角色模块")
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @ApiOperation(value = "发送验证码")
    @PostMapping("code")
    public Result sendCode(@RequestBody
                               @Validated LoginFormDTO LoginFormDTO){
        return userService.sendCode(LoginFormDTO.getEmail());
    }

    @ApiOperation(value = "email登录")
    @PostMapping ("login/email")
    public Result loginByEmail(@RequestBody @Validated LoginFormDTO loginFormDTO){
        return userService.loginByEmail(loginFormDTO);
    }

    @ApiOperation(value = "获取个人简单信息")
    @GetMapping("/me")
    public Result me(){
        UserDTO user= UserHolder.getUser();
        return Result.ok(user);
    }

}
