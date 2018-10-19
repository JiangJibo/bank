package com.bob.bank.account.web.service;

import com.bob.bank.client.model.BankAccount;

/**
 * @author wb-jjb318191
 * @create 2018-10-19 16:56
 */
public interface BankAccountService {

    /**
     * @param bankAccount
     * @return
     */
    int create(BankAccount bankAccount);

    /**
     * @param id
     * @return
     */
    BankAccount getById(Integer id);

}