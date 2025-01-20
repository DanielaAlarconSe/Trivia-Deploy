package com.ciber.util;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class AppConfig {

    @Value("${spring.datasource.url}")
    private String datasourceUrl;

    @Value("${spring.datasource.username}")
    private String datasourceUsername;

    @Value("${spring.datasource.password}")
    private String datasourcePassword;

    @Value("${spring.datasource.driver-class-name}")
    private String datasourceDriverClassName;

    @Bean(name = "JDBCTemplateConsulta")
    public JdbcTemplate jdbcTemplateConsultas() {
        return new JdbcTemplate(dataSourceConsulta());
    }

    @Bean(name = "JDBCTemplateLogin")
    public JdbcTemplate jdbcTemplateLogin() {
        return new JdbcTemplate(dataSourceLogin());
    }

    @Bean(name = "JDBCTemplateEjecucion")
    public JdbcTemplate jdbcTemplateEjecucion() {
        return new JdbcTemplate(dataSourceEjecucion());
    }

    @Bean
    public DataSource dataSourceConsulta() {
        return DataSourceBuilder.create()
                .url(datasourceUrl)
                .username(datasourceUsername)
                .password(datasourcePassword)
                .driverClassName(datasourceDriverClassName)
                .build();
    }

    @Bean
    public DataSource dataSourceLogin() {
        return DataSourceBuilder.create()
                .url(datasourceUrl)
                .username(datasourceUsername)
                .password(datasourcePassword)
                .driverClassName(datasourceDriverClassName)
                .build();
    }

    @Bean
    public DataSource dataSourceEjecucion() {
        return DataSourceBuilder.create()
                .url(datasourceUrl)
                .username(datasourceUsername)
                .password(datasourcePassword)
                .driverClassName(datasourceDriverClassName)
                .build();
    }
}
