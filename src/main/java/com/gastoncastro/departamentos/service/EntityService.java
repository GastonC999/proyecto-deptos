package com.gastoncastro.departamentos.service;

import java.util.List;

public interface EntityService<T> {
    List<T> getListEntidades(String startWith);
    T porId(Long id);
    T guardar(T t);
    void eliminar(Long id);
}
