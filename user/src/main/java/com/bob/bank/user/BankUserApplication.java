package com.bob.bank.user;

import com.bob.bank.client.base.BaseMapper;
import com.bob.bank.client.config.MybatisConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * @author wb-jjb318191
 * @create 2018-10-19 11:40
 */
@SpringBootApplication
@Import(MybatisConfiguration.class)
@MapperScan(basePackages = "com.bob.bank.user.mapper", markerInterface = BaseMapper.class)
public class BankUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankUserApplication.class, args);
    }

}
