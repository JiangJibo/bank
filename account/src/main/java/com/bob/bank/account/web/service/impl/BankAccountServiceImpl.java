package com.bob.bank.account.web.service.impl;

import com.bob.bank.account.web.mapper.BankAccountMapper;
import com.bob.bank.account.web.service.BankAccountService;
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
        return bankAccountMapper.insert(bankAccount);
    }

    @Override
    public BankAccount getById(Integer id) {
        return bankAccountMapper.selectById(id);
    }
}
