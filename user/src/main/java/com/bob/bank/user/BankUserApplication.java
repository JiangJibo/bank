package com.bob.bank.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.bootstrap.BootstrapConfiguration;

/**
 * @author wb-jjb318191
 * @create 2018-10-19 11:40
 */
@SpringBootApplication
@BootstrapConfiguration
public class BankUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankUserApplication.class, args);
    }

}
