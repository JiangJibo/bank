package com.bob.bank.client.export.user;

import com.bob.bank.client.export.user.fallback.BankUserFeignFallback;
import com.bob.bank.client.model.BankUser;
import com.bob.bank.client.result.PojoResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wb-jjb318191
 * @create 2018-10-19 17:45
 */
@RequestMapping("/bank/user")
@FeignClient(value = "bank-user", fallback = BankUserFeignFallback.class)
public interface BankUserFeignService {

    /**
     * 创建用户
     *
     * @param bankUser
     * @return
     */
    @PostMapping
    PojoResult<Boolean> createUser(BankUser bankUser);

    /**
     * 验证指定用户是存在和激活中
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    PojoResult<Boolean> checkIfUserApplicable(@PathVariable Integer id);

}