package com.bob.bank.client.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

/**
 * Mybatis配置
 *
 * @author wb-jjb318191
 * @create 2018-10-19 14:45
 */
@Configuration
@PropertySource("classpath:database-config.properties")
public class MybatisConfiguration {

    @Value("${mysql.url}")
    private String url;

    @Value("${mysql.userName}")
    private String userName;

    @Value("${mysql.password}")
    private String password;

    @Value("${mysql.driverClassName}")
    private String driverClassName;
    /**
     * 写数据源
     *
     * @return
     */
    @Bean(destroyMethod = "close")
    public BasicDataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(driverClassName);
        //针对mysql获取字段注释
        dataSource.addConnectionProperty("useInformationSchema", "true");
        dataSource.setUrl(url);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        dataSource.setMaxTotal(10);
        dataSource.setMinIdle(2);
        dataSource.setMaxIdle(5);
        return dataSource;
    }

    /**
     * 事务管理器
     *
     * @param dataSource
     * @return
     */
    @Bean
    public DataSourceTransactionManager txManager(BasicDataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    /**
     * SqlSession工厂
     *
     * @param dataSource
     * @return
     * @throws Exception
     */
    @Bean
    public SqlSessionFactory sqlSessionFactory(BasicDataSource dataSource) throws Exception {
        // 配置MapperConfig
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setDefaultExecutorType(ExecutorType.REUSE);
        // 全局启用或禁用延迟加载，禁用时所有关联对象都会即时加载
        configuration.setLazyLoadingEnabled(false);
        // 设置SQL语句执行超时时间缺省值，具体SQL语句仍可以单独设置
        configuration.setDefaultStatementTimeout(5000);

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setConfiguration(configuration);
        // 匹配多个 MapperConfig.xml, 使用mappingLocation属性
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*Mapper.xml"));
        return sqlSessionFactoryBean.getObject();
    }


}
