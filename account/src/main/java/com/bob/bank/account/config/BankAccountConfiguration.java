package com.bob.bank.account.config;

import com.bob.bank.client.base.BaseMapper;
import com.bob.bank.client.config.MybatisConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 配置类
 *
 * @author wb-jjb318191
 * @create 2018-10-19 14:42
 */
@Configuration
@Import(MybatisConfiguration.class)
@MapperScan(basePackages = "com.bob.bank.account.web.mapper", markerInterface = BaseMapper.class)
public class BankAccountConfiguration {



}
