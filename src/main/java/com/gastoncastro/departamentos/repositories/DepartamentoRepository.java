package com.gastoncastro.departamentos.repositories;

import com.gastoncastro.departamentos.modelo.Departamento;
import com.gastoncastro.departamentos.service.EntityService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DepartamentoRepository implements CRUDRepository<Departamento>{

    @Autowired
    private EntityManager em;

    @Override
    public List<Departamento> listar() {
        return em.createQuery("SELECT d FROM Departamento d", Departamento.class).getResultList();
    }

    @Override
    public Departamento porId(Long id) {
        return em.find(Departamento.class,id);
    }

    @Override
    public void guardar(Departamento departamento) {
        if (departamento.getId() !=null && departamento.getId() > 0){
        em.merge(departamento);
        }
        else{
            em.persist(departamento);
        }
    }

    @Override
    public void eliminar(Long id) {
        Departamento departamento = porId(id);
        em.remove(departamento);
    }
}
