package com.bob.bank.user.service.impl;

import com.bob.bank.client.export.account.BankAccountFeignService;
import com.bob.bank.user.mapper.BankUserMapper;
import com.bob.bank.user.service.BankUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wb-jjb318191
 * @create 2018-10-23 9:48
 */
@Service
public class BankUserServiceImpl implements BankUserService {

    @Autowired
    private BankAccountFeignService bankAccountFeignService;

    @Autowired
    private BankUserMapper bankUserMapper;

    @Override
    public boolean upgradeAccountRank(Integer userId) {
        return false;
    }

    @Override
    public boolean checkIfUserExists(Integer userId) {
        return bankUserMapper.selectByPrimaryKey(userId) != null;
    }
}
