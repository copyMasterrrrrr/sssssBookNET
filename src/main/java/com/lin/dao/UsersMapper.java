package com.lin.dao;

import com.lin.common.general.GeneralDAO;
import com.lin.entity.Users;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersMapper extends GeneralDAO<Users> {
    public Users selectByUserName(String userName);
    public int updRoleByName(String userName);

}