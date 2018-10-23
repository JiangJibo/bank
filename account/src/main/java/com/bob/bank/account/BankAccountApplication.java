package com.bob.bank.account;

import com.bob.bank.client.base.BaseMapper;
import com.bob.bank.client.config.MybatisConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;

/**
 * @author wb-jjb318191
 * @create 2018-10-19 12:10
 */
@EnableEurekaClient
@Import(MybatisConfiguration.class)
@EnableFeignClients("com.bob.bank.client.export.user")
@MapperScan(basePackages = "com.bob.bank.account.mapper", markerInterface = BaseMapper.class)
@SpringBootApplication(scanBasePackages = {"com.bob.bank.account", "com.bob.bank.client.export.user"})
public class BankAccountApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankAccountApplication.class, args);
    }

}
