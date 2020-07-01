package com.myitem.dao;

import com.myitem.domain.Account;

import java.util.List;

public interface AccountDao{
    /**
     * 查询所有账号
     *
     * @return
     */
    List<Account> findAccount();

    /**
     * 一个账号只属于一个用户
     * @return
     */
    List<Account> findAllAccount();
}
