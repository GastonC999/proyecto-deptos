package com.gastoncastro.departamentos.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Jpautil {
    private static final EntityManagerFactory entityManagerFactory = buildEntityManagerFactory();
    private static EntityManagerFactory buildEntityManagerFactory(){
        return Persistence.createEntityManagerFactory("proyectoDeptos");
    }
    public static EntityManager getEntityManager(){
        return entityManagerFactory.createEntityManager();
    }

}
