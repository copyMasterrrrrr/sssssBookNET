package com.lin.service;

import com.lin.common.VO.ResultVO;

public interface UserService {
    //用户登录
    public ResultVO checkLogin(String userName,String password);

    //用户注册
    public ResultVO userRegistered(String userName,String password);

    //根据用户名查询用户
    public ResultVO selectUserByName(String userName);

    //根据用户名修改用户权限
    public ResultVO updRoleByName(String userName);
}
