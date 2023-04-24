package com.gastoncastro.departamentos;

import com.gastoncastro.departamentos.modelo.Departamento;
import com.gastoncastro.departamentos.util.Jpautil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class HibernateResultListWhere {
    public static void main(String[] args) {
        EntityManager em = Jpautil.getEntityManager();
        Query query = em.createQuery("select d from Departamento d where d.nombre=?1", Departamento.class);
        query.setParameter(1, "Marisa");
        Departamento d = (Departamento) query.getSingleResult();
        em.close();
    }
}
