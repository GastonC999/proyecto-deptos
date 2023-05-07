package com.gastoncastro.departamentos.repositories;

import com.gastoncastro.departamentos.modelo.entity.Persona;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class PersonaRepository implements CRUDRepository<Persona>{

    @Autowired
    private EntityManager em;

    @Override
    public List<Persona> listar() {
        return em.createQuery("SELECT p FROM Persona p", Persona.class).getResultList();
    }

    @Override
    public Persona porId(Long id) {
        return em.find(Persona.class, id);
    }

    @Override
    public void guardar(Persona persona) {
    if (persona.getId() !=null && persona.getId() > 0){
        em.merge(persona);
    }else {
        em.persist(persona);
    }
    }

    @Override
    public void eliminar(Long id) {
        Persona persona = porId(id);
        em.remove(persona);
    }
}
