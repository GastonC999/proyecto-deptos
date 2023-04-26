package com.gastoncastro.departamentos.service;

import java.util.List;

public interface EntityService<D, E> {
    List<E> getListEntidades();
    E porId(Long id);
    E guardar(D dto);
    void eliminar(Long id);
}
