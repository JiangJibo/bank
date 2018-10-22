package com.bob.bank.user.config;

import com.bob.bank.client.base.BaseMapper;
import com.bob.bank.client.config.MybatisConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author Administrator
 * @create 2018-10-22 19:31
 */
@Configuration
@Import(MybatisConfiguration.class)
@MapperScan(basePackages = "com.bob.bank.user.web.mapper", markerInterface = BaseMapper.class)
public class BankUserConfiguration {
}
