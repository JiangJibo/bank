package com.bob.bank.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author wb-jjb318191
 * @create 2018-10-19 12:10
 */
@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients("com.bob.bank.client.export.user")
public class BankAccountApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankAccountApplication.class, args);
    }

}
