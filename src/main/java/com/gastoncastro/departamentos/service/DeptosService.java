package com.gastoncastro.departamentos.service;

import com.gastoncastro.departamentos.modelo.Departamento;
import com.gastoncastro.departamentos.repositories.CRUDRepository;
import jakarta.persistence.EntityManager;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeptosService implements EntityService<Departamento> {

    private EntityManager em;
    private CRUDRepository<Departamento> repository;

    public List<Departamento> getListEntidades(String nombreSubstring){
        if (nombreSubstring != null){
            return repository.listar().stream()
                    .filter(d -> (d.getDireccion() + " " + d.getNumero()).startsWith(nombreSubstring))
                    .collect(Collectors.toList());
        }else {
            return repository.listar();
        }
    }

    public List<Departamento> getListEntidades() {
        return repository.listar();
    }
    @Override
    public Departamento porId(Long id) {
        return repository.listar().stream().filter(d ->
                        d.getId().equals(id)).findAny()
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,
                                String.format("Departamento inexistente")));
    }

    public Departamento guardar(Departamento departamento) {
        if (repository.listar().stream().anyMatch(d ->
                d.getDireccion().equals(departamento.getDireccion()))) {
            if (repository.listar().stream().anyMatch(d ->
                    d.getNumero().equals(departamento.getNumero()))) {
                throw new ResponseStatusException(HttpStatus.CONFLICT,
                        String.format("El departamento ya existe"));
            }
        }
        try{
            em.getTransaction().begin();
            repository.guardar(departamento);
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }
        return departamento;
    }


    public Departamento UpdateDepto(Departamento departamento, long id) {
        Departamento deptotoBeUpdate = porId(id);
        deptotoBeUpdate.setNombre(departamento.getNombre());
        deptotoBeUpdate.setDireccion(departamento.getDireccion());
        deptotoBeUpdate.setNumero(departamento.getNumero());
        deptotoBeUpdate.setPiso(departamento.getPiso());
        return deptotoBeUpdate;
    }


    @Override
    public void eliminar(Long id) {
        try {
            em.getTransaction().begin();
            repository.eliminar(id);
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}