package com.lin.controller;


import com.lin.common.VO.ResultVO;
import com.lin.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
@Api(value = "提供用户登录注册的接口",tags = "用户管理")
public class UserController {
    @Resource
    private UserService userService;

    @CrossOrigin
    @GetMapping("/login")
    @ApiOperation("用户登录接口")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "string",name = "username",value = "用户登录账号",required = true),
            @ApiImplicitParam(dataType = "string",name = "password",value = "用户登录密码",required = true)

    })
    public ResultVO login(@RequestParam("username") String username, @RequestParam(value = "password")String password){
        return userService.checkLogin(username, password);
    }



    @CrossOrigin
    @PostMapping("/registered")
    @ApiOperation("用户注册接口")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "string",name = "username",value = "用户注册账号",required = true),
            @ApiImplicitParam(dataType = "string",name = "password",value = "用户注册密码",required = true)

    })
    public ResultVO registered(@RequestParam("username") String username, @RequestParam(value = "password")String password){
        return userService.userRegistered(username, password);
    }


    @CrossOrigin
    @GetMapping("/selecteByName")
    @ApiOperation("根据用户名查询用户接口")
    @ApiImplicitParam(dataType = "string",name = "userName",value = "用户名")
    public ResultVO selectUserByName(@RequestParam("userName") String userName){
        return userService.selectUserByName(userName);
    }


    @CrossOrigin
    @GetMapping("/updrole")
    @ApiOperation("根据用户名升级用户权限接口")
    @ApiImplicitParam(dataType = "string",name = "userName",value = "用户名")
    public ResultVO updRoleByName(@RequestParam("userName") String userName){
        return userService.updRoleByName(userName);
    }


}
