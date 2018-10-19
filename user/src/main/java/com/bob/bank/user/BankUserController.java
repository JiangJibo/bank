package com.bob.bank.user;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EurekaClientConfigBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wb-jjb318191
 * @create 2018-10-19 11:58
 */
@RestController
@RequestMapping("/bankUser")
public class BankUserController {

    @Autowired
    public EurekaClientConfigBean eurekaClientConfigBean;

    @PostConstruct
    public void init() {
        System.out.println(eurekaClientConfigBean.toString());
    }

}
