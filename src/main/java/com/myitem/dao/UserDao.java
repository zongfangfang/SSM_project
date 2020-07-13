package com.myitem.dao;

import com.myitem.domain.QueryVo;
import com.myitem.domain.User;
import com.myitem.domain.UserAccount;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;
//使用二级缓存
@CacheNamespace(blocking = false)
public interface UserDao {
    /**
     * 查询所有用户信息，并且查询一个用户下所有的账号
     * @return
     */
    @Select("select * from user")
    @Results(id="userMap",value={
            @Result(id=true,column = "id",property = "id"),
            @Result(property="username", column="username"),
            @Result(property="address", column="address"),
            @Result(property="sex", column="sex"),
            @Result(property="birthday", column="birthday")
            @Result(property = "accountList", column = "id",many = @Many(select="com.myitem.dao.findAccountByUid",fetchType = FetchType.LAZY))
    })
    List<UserAccount> findAll();

    /**
     * 保存用户属性
     * @param user
     */
    @Insert(" insert into user(username,address,sex,birthday) values (#{username},#{address},#{sex},#{birthday})")
    void saveUser(User user);

    /**
     * 根据ID删除用户
     * @param id
     */
    @Delete("delete from user where id=#{id}")
    void deleteUser(Integer id);

    /**
     * 更新用户信息
     * @param user
     */
    @Update("update user set username=#{username},address=#{address} where id=#{id}")
    void updateUser(User user);

    /**
     * 根据用户ID查询用户信息
     * @param id
     * @return
     */
    @Select("select * from user where id=#{id}")
    @ResultMap(value = {"userMap"})
    User findUserById(Integer id);

    /**
     * 模糊查询用户信息
     * 测试类中不要加%
     * @param name
     * @return
     */
    @Select("select * from user where username like '%${value}%'")
    @ResultMap(value = {"userMap"})
    List<User> findUserByName(String name);

    /**
     * 根据条件查询User
     * @param user
     * @return
     */
    List<User> findUserByCondition(User user);

    /**
     * 根据ids查询User
     * @param vo
     * @return
     */
    List<User> findUserByids(QueryVo vo);
}
