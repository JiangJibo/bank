package com.bob.bank.client.export.user.fallback;

import com.bob.bank.client.export.user.BankUserFeignService;
import com.bob.bank.client.model.BankUser;
import com.bob.bank.client.result.PojoResult;
import org.springframework.stereotype.Service;

/**
 * @author wb-jjb318191
 * @create 2018-10-23 14:21
 */
@Service
public class BankUserFeignFallback implements BankUserFeignService {

    @Override
    public PojoResult<Boolean> createUser(BankUser bankUser) {
        return null;
    }

    @Override
    public PojoResult<Boolean> checkIfUserApplicable(Integer id) {
        return null;
    }
}
