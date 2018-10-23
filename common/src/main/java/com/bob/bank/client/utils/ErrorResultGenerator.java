package com.bob.bank.client.utils;

import com.bob.bank.client.result.PojoResult;

import static com.bob.bank.client.constants.ErrorCodeEnum.REST_REQUEST_ERROR;

/**
 * @author wb-jjb318191
 * @create 2018-10-23 16:58
 */
public abstract class ErrorResultGenerator {

    /**
     * 生成简单类型的结果
     *
     * @param t
     * @param <T>
     * @return
     */
    public static <T> PojoResult<T> generatePojoResult(T t) {
        PojoResult<T> result = new PojoResult<>(t);
        result.setErrorMessage(REST_REQUEST_ERROR.getCode(), REST_REQUEST_ERROR.getLabel());
        return result;
    }

}
