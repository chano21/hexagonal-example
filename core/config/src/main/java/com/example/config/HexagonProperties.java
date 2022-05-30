package com.example.config;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "hexagon")
public class HexagonProperties {

    DatabaseProperties database;
    HibernateProperties hibernate;
    MongoProperties mongo;

    @Getter
    @Setter
    @Configuration
    @ToString
    @ConfigurationProperties(prefix = "hexagon.mongodb")
    public static class MongoProperties {
        String userName;
        String password;
        String database;
        String host;
        int port;
    }


    @Getter
    @Setter
    @Configuration
    @ToString
    @ConfigurationProperties(prefix = "hexagon.datasource")
    public static class DatabaseProperties {
        String password;
        String username;
        String driverClassName;
        String url;
    }

    @Getter
    @Setter
    @ToString
    @Configuration
    @ConfigurationProperties(prefix = "hexagon.hibernate")
    public static class HibernateProperties {
      String showSql;
      String formatSql;
        String sqlComments;
        String ddlAuto;
        String dialect;
    }

    @Getter
    @Setter
    @ToString
    @Configuration
    @ConfigurationProperties(prefix = "hexagon.redis")
    public static class RedisProperties {
        String host;
        int port;
    }






}