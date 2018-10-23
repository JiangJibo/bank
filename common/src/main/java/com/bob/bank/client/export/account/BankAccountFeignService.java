package com.bob.bank.client.export.account;

import com.bob.bank.client.export.account.fallback.BankAccountFeignFallback;
import com.bob.bank.client.model.BankAccount;
import com.bob.bank.client.result.PojoResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wb-jjb318191
 * @create 2018-10-19 17:06
 */
@RequestMapping("/bank/account")
@FeignClient(value = "bank-account", fallback = BankAccountFeignFallback.class)
public interface BankAccountFeignService {

    /**
     * 创建账号
     *
     * @param bankAccount
     * @return
     */
    @PostMapping
    PojoResult<Boolean> createAccount(BankAccount bankAccount);

}