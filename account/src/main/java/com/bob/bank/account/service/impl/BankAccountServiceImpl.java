package com.bob.bank.account.service.impl;

import com.bob.bank.account.mapper.BankAccountMapper;
import com.bob.bank.account.service.BankAccountService;
import com.bob.bank.client.export.user.BankUserFeignService;
import com.bob.bank.client.model.BankAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wb-jjb318191
 * @create 2018-10-19 16:56
 */
@Service
public class BankAccountServiceImpl implements BankAccountService {

    @Autowired
    private BankUserFeignService bankUserFeignService;

    @Autowired
    private BankAccountMapper bankAccountMapper;

    @Override
    public int create(BankAccount bankAccount) {
        Integer userId = bankAccount.getUserId();
        boolean applicable = bankUserFeignService.checkIfUserApplicable(userId).getContent();
        if (!applicable) {
            throw new IllegalArgumentException(String.format("用户ID:[%s]不存在", userId));
        }
        boolean exists = bankAccountMapper.checkIfAccountExists(userId);
        if(exists){
            throw new IllegalArgumentException(String.format("用户ID:[%s]账户已存在,不能重复创建", userId));
        }
        return bankAccountMapper.insert(bankAccount);
    }

    @Override
    public BankAccount getById(Integer id) {
        return bankAccountMapper.selectById(id);
    }
}
