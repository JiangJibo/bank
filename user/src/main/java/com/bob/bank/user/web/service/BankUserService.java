package com.bob.bank.user.web.service;

/**
 * @author wb-jjb318191
 * @create 2018-10-23 9:47
 */
public interface BankUserService {

    /**
     * 提升账户等级
     *
     * @param userId
     * @return
     */
    boolean upgradeAccountRank(Integer userId);

}