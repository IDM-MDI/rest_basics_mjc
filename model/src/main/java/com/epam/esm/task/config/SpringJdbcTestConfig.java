package com.epam.esm.task.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.sql.DataSource;

@Configuration
@ComponentScan("com.epam.esm")
@PropertySource("classpath:testDataBase.properties")
@Profile("test")
public class SpringJdbcTestConfig {
    @Value("${url}")
    private String url;
    @Value("${driverName}")
    private String driverName;
    @Value("${username}")
    private String username;
    @Value("${password}")
    private String password;

    @Bean("dataSourceTest")
    public DataSource getMysqlTestDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword("");

        Resource initSchema = new ClassPathResource("schema.sql");
        Resource fillData = new ClassPathResource("fillData.sql");

        DatabasePopulator databasePopulator = new ResourceDatabasePopulator(initSchema,fillData);
        DatabasePopulatorUtils.execute(databasePopulator, dataSource);

        return dataSource;
    }

    @Bean
    public JdbcTemplate getJdbcTemplateTest(@Autowired @Qualifier("dataSourceTest") DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
}
