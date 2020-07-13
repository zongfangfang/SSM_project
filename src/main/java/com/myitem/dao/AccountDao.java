package com.myitem.dao;

import com.myitem.domain.Account;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface AccountDao{
    /**
     * 查询所有账号
     *
     * @return
     */
    @Select("select * from account where uid=#{uid}")
    List<Account> findAccountByUid(Integer uid);

    /**
     * 一个账号只属于一个用户
     * @return
     */
    @Select("select * from account ")
    @Results(id="accountMap",value = {
            @Result(id=true,column = "id",property = "id"),
            @Result(property="uid", column="uid"),
            @Result(property="money", column="money"),
            @Result(property = "user",column = "uid",
                    one=@One(select="com.myitem.dao.UserDao.findUserById",fetchType= FetchType.EAGER))
    })
    List<Account> findAllAccount();
}
