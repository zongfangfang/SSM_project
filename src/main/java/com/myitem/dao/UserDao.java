package com.myitem.dao;

import com.myitem.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserDao {
    /**
     * 查询所有用户信息
     * @return
     */
    @Select("select * from user")
    List<User> findAll();
}
