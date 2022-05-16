package com.example.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Configuration
@EnableJpaAuditing
public class JpaConfig {

    @PersistenceContext
    private EntityManager entityManager;

}