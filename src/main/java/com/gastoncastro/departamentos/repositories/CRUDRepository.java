package com.gastoncastro.departamentos.repositories;

import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CRUDRepository<T> {
    List<T> listar();
    T porId(Long id);
    void guardar(T t);
    void eliminar(Long id);
}