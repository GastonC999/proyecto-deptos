package com.gastoncastro.departamentos.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class JpaUtil {
    private static final EntityManagerFactory entityManagerFactory = buildEntityManagerFactory();
    private static EntityManagerFactory buildEntityManagerFactory(){
        return Persistence.createEntityManagerFactory("proyectoDeptos");
    }
   @Bean
    public static EntityManager getEntityManagerFactory(){
        return entityManagerFactory.createEntityManager();
    }

}