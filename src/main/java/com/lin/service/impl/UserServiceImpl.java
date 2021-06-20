package com.lin.service.impl;

import com.lin.common.utils.MD5Utils;
import com.lin.dao.UsersMapper;
import com.lin.common.VO.ResultVO;
import com.lin.entity.Users;
import com.lin.service.UserService;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Scope("singleton")
public class UserServiceImpl implements UserService {

    @Autowired
    UsersMapper usersMapper;
    @Override
    public ResultVO checkLogin(String userName, String password) {
        //创建一个example
        Users user = usersMapper.selectByUserName(userName);
        if (user==null){
            return new ResultVO(101,"账户或密码不正确",null);
        }else{
            String md5 = MD5Utils.md5(password);
            if (md5.equals(user.getPassword())){
                JwtBuilder builder = Jwts.builder();

                String token =
                        builder.setSubject(user.getUserRole()+"")
                        .setIssuedAt(new Date())
                        //.setClaims()
                        .setExpiration(new Date(System.currentTimeMillis()+24 * 60 * 60 * 100))
                        .signWith(SignatureAlgorithm.HS256,"sssss")
                        .setId(user.getUserId().toString())
                        .compact();
                return new ResultVO(102,token,user);
            }else{
                return new ResultVO(101,"账户或密码不正确",null);
            }
        }

    }




    @Override
    @Transactional
    public ResultVO userRegistered(String userName, String password) {
        Users checkUser = usersMapper.selectByUserName(userName);
        if (checkUser==null){
            String md5 = MD5Utils.md5(password);
            Users user = new Users();
            user.setUserName(userName);
            user.setPassword(md5);
            user.setUserRegtime(new Date());
            user.setUserModtime(new Date());
            user.setUserRole(0);
            int i = usersMapper.insertUseGeneratedKeys(user);
            if (i>0){
                return new ResultVO(201,"注册成功",user);
            }else {
                return new ResultVO(200,"注册失败",null);
            }
        }else{
            return new ResultVO(203,"用户名已被注册",null);
        }
    }

    @Override
    public ResultVO selectUserByName(String userName) {
        Users users = usersMapper.selectByUserName(userName);
        if (users==null){
            return new ResultVO(108,"查询失败，或数据库中无此用户信息",null);
        }else{
            return new ResultVO(109,"查询成功",users);
        }


    }

    @Override
    public ResultVO updRoleByName(String userName) {
        int i = usersMapper.updRoleByName(userName);
        if (i>0){
            return new ResultVO(10009,"成功升级为vip",null);
        }else{
            return new ResultVO(10001,"权限升级失败",null);
        }

    }
}
