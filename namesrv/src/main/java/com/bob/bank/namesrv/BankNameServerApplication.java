package com.bob.bank.namesrv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author Administrator
 * @create 2018-10-22 19:38
 */
@EnableEurekaServer
@SpringBootApplication
public class BankNameServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankNameServerApplication.class, args);
    }
}
