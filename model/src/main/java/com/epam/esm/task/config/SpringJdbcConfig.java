package com.epam.esm.task.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@ComponentScan("com.epam.esm")
@EnableTransactionManagement
@PropertySource("classpath:db.properties")
public class SpringJdbcConfig {
    @Value("${url}")
    private String url;
    @Value("${driverName}")
    private String driverName;
    @Value("root")
    private String username;
    @Value("${password}")
    private String password;

    @Bean("dataSource")
    public DataSource getMysqlDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword("");
        return dataSource;
    }
    @Bean
    public JdbcTemplate getJdbcTemplate(@Autowired @Qualifier("dataSource") DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public DataSourceTransactionManager getDataSourceTransactionManager(@Autowired @Qualifier("dataSource") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }
 }
