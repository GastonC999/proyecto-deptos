package com.gastoncastro.departamentos.service;

import com.gastoncastro.departamentos.modelo.Departamento;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeptosService {

    private List<Departamento> deptos = new ArrayList<>();

    public Departamento CreateDepto(Departamento departamento) {
        if (deptos.stream().anyMatch(d ->
                d.getDireccion().equals(departamento.getDireccion()))){
            if (deptos.stream().anyMatch(d ->
                    d.getNumero().equals(departamento.getNumero()))) {
                    throw new ResponseStatusException(HttpStatus.CONFLICT,
                    String.format("El departamento ya existe"));
                }
            }
        deptos.add(departamento);
        return departamento;
    }

        public List<Departamento> getDeptos () {
            return deptos;
        }
    }
