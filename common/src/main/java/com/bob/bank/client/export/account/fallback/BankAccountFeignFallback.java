package com.bob.bank.client.export.account.fallback;

import com.bob.bank.client.export.account.BankAccountFeignService;
import com.bob.bank.client.model.BankAccount;
import com.bob.bank.client.result.PojoResult;

import static com.bob.bank.client.constants.ErrorCodeEnum.REST_REQUEST_ERROR;

/**
 * @author wb-jjb318191
 * @create 2018-10-23 14:20
 */
public class BankAccountFeignFallback implements BankAccountFeignService {

    @Override
    public PojoResult<Boolean> createAccount(BankAccount bankAccount) {
        PojoResult<Boolean> result = new PojoResult<>(false);
        result.setErrorMessage(REST_REQUEST_ERROR.getCode(), REST_REQUEST_ERROR.getLabel());
        return result;
    }
}
