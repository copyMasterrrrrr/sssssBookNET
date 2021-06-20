package com.lin.entity;

import java.util.Date;
import javax.persistence.*;

public class Users {
    /**
     * 主键id 用户id
     */
    @Id
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 用户名 用户名
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 密码 密码
     */
    private String password;

    /**
     * 注册时间 创建时间
     */
    @Column(name = "user_regtime")
    private Date userRegtime;

    /**
     * 更新时间 更新时间
     */
    @Column(name = "user_modtime")
    private Date userModtime;

    /**
     * 0为普通用户 1为vip用户 2为管理员
     */
    @Column(name = "user_role")
    private Integer userRole;

    /**
     * 获取主键id 用户id
     *
     * @return user_id - 主键id 用户id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置主键id 用户id
     *
     * @param userId 主键id 用户id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取用户名 用户名
     *
     * @return user_name - 用户名 用户名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户名 用户名
     *
     * @param userName 用户名 用户名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取密码 密码
     *
     * @return password - 密码 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码 密码
     *
     * @param password 密码 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取注册时间 创建时间
     *
     * @return user_regtime - 注册时间 创建时间
     */
    public Date getUserRegtime() {
        return userRegtime;
    }

    /**
     * 设置注册时间 创建时间
     *
     * @param userRegtime 注册时间 创建时间
     */
    public void setUserRegtime(Date userRegtime) {
        this.userRegtime = userRegtime;
    }

    /**
     * 获取更新时间 更新时间
     *
     * @return user_modtime - 更新时间 更新时间
     */
    public Date getUserModtime() {
        return userModtime;
    }

    /**
     * 设置更新时间 更新时间
     *
     * @param userModtime 更新时间 更新时间
     */
    public void setUserModtime(Date userModtime) {
        this.userModtime = userModtime;
    }

    /**
     * 获取0为普通用户 1为vip用户
     *
     * @return user_role - 0为普通用户 1为vip用户
     */
    public Integer getUserRole() {
        return userRole;
    }

    /**
     * 设置0为普通用户 1为vip用户
     *
     * @param userRole 0为普通用户 1为vip用户
     */
    public void setUserRole(Integer userRole) {
        this.userRole = userRole;
    }
}