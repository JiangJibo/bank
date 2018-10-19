package com.bob.bank.client.export.user;

import com.bob.bank.client.model.BankUser;
import com.bob.bank.client.result.PojoResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wb-jjb318191
 * @create 2018-10-19 17:45
 */
@FeignClient("bank-user")
@RequestMapping("/bank/user")
public interface BankUserFeignService {

    /**
     * 创建用户
     *
     * @param bankUser
     * @return
     */
    @PostMapping
    PojoResult<Boolean> createUser(BankUser bankUser);

}