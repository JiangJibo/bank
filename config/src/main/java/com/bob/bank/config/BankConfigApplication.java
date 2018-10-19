package com.bob.bank.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.autoconfigure.RefreshAutoConfiguration;
import org.springframework.cloud.bootstrap.config.PropertySourceBootstrapConfiguration;
import org.springframework.cloud.config.client.ConfigServicePropertySourceLocator;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.config.server.config.ConfigServerProperties;
import org.springframework.cloud.config.server.environment.EnvironmentController;
import org.springframework.cloud.context.refresh.ContextRefresher;
import org.springframework.cloud.endpoint.RefreshEndpoint;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

/**
 * 配置选项：{@link ConfigServerProperties}
 * 默认情况下Client初始化时通过
 * {@link ConfigServicePropertySourceLocator#locate(Environment)}
 * 向Server发送请求
 *
 * @RequestMapping("/{name}/{profiles}/{label:.*}") {@link EnvironmentController#labelled(String, String, String)} 中,
 *
 * 容器数据刷新配置类: {@link RefreshAutoConfiguration}
 *
 * * SpringCloudConfig 请求 /refresh 时刷新容器内Environment信息的流程:
 * >> {@link RefreshEndpoint#refresh()}
 * >> {@link ContextRefresher#addConfigFilesToEnvironment}
 * >> {@link SpringApplicationBuilder#run(String...)}
 * >> {@link SpringApplication#run(String...)}
 * >> {@link SpringApplication#prepareContext}
 * >> {@link SpringApplication#applyInitializers(ConfigurableApplicationContext)}
 * >> {@link PropertySourceBootstrapConfiguration#initialize(ConfigurableApplicationContext)}
 * >> {@link ConfigServicePropertySourceLocator#locate(Environment)}
 */
@EnableConfigServer
@SpringBootApplication
public class BankConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankConfigApplication.class, args);
    }
}
