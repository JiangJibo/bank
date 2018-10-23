package com.bob.bank.account.controller;

import com.bob.bank.account.service.BankAccountService;
import com.bob.bank.client.model.BankAccount;
import com.bob.bank.client.result.PojoResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wb-jjb318191
 * @create 2018-10-19 16:58
 */
@RestController
@RequestMapping("/bank/account")
public class BankAccountController {

    @Autowired
    private BankAccountService bankAccountService;

    /**
     * 创建账号
     *
     * @param bankAccount
     * @return
     */
    @PostMapping
    public PojoResult<Boolean> createAccount(@RequestBody BankAccount bankAccount) {
        return new PojoResult<>(bankAccountService.create(bankAccount) > 0);
    }

}
