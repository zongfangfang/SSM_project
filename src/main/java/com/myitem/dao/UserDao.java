package com.myitem.dao;

import com.myitem.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserDao {
    /**
     * 查询所有用户信息
     * @return
     */
//    @Select("select * from user")
    List<User> findAll();

    /**
     * 保存用户属性
     * @param user
     */
    void saveUser(User user);

    /**
     * 根据ID删除用户
     * @param id
     */
    void deleteUser(Integer id);

    /**
     * 更新用户信息
     * @param user
     */
    void updateUser(User user);

    /**
     * 根据用户ID查询用户信息
     * @param id
     * @return
     */
    User findUserById(Integer id);

    /**
     * 模糊查询用户信息
     * @param name
     * @return
     */
    List<User> findUserByName(String name);

    /**
     * 根据条件查询User
     * @param user
     * @return
     */
    List<User> findUserByCondition(User user);
}
