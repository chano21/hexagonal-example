package com.example.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "hexagonEntityManager", transactionManagerRef = "hexagonTransactionManager",
        basePackages = {"com.example.adapter.out.adapter.db.repository"})
@RequiredArgsConstructor
@EntityScan(value = {"com.example.adapter.out.adapter.db.*"})
public class DatabaseConfig {

private final HexagonProperties.DatabaseProperties databaseProperties;

  private final  HexagonProperties.HibernateProperties hibernateProperties;

    @Bean
    public DataSource hexagonDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(databaseProperties.getDriverClassName());
        dataSource.setUrl(databaseProperties.getUrl());
        dataSource.setUsername(databaseProperties.getUsername());
        dataSource.setPassword(databaseProperties.getPassword());


        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean hexagonEntityManager() {
        LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        HashMap<String, Object> properties = new HashMap<>();
        localContainerEntityManagerFactoryBean.setDataSource(hexagonDataSource());
        localContainerEntityManagerFactoryBean.setPackagesToScan(new String[] { "com.example.adapter.out.adapter.db.*"});
        localContainerEntityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter);
        properties.put("hibernate.dialect", hibernateProperties.getDialect());
        properties.put("hibernate.format_sql",hibernateProperties.getFormatSql());
        properties.put("hibernate.show_sql", hibernateProperties.getShowSql());
        properties.put("hibernate.use_sql_comments", hibernateProperties.getSqlComments());
        properties.put("hibernate.hbm2ddl.auto", hibernateProperties.getDdlAuto());

        localContainerEntityManagerFactoryBean.setJpaPropertyMap(properties);
        return localContainerEntityManagerFactoryBean;
    }

    @Bean
    public PlatformTransactionManager hexagonTransactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(hexagonEntityManager().getObject());
        return transactionManager;
    }
}