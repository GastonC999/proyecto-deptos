package com.gastoncastro.departamentos;

import com.gastoncastro.departamentos.modelo.Departamento;
import com.gastoncastro.departamentos.util.Jpautil;
import jakarta.persistence.EntityManager;

import java.util.List;

public class probamosListar {
    public static void main(String[] args) {


        EntityManager em = Jpautil.getEntityManager();
        em.createQuery("select d from Departamento d");

        List<Departamento> depto = em.createQuery("select d from Departamento d").getResultList();
        depto.forEach(System.out::println);
        em.close();
    }
}
