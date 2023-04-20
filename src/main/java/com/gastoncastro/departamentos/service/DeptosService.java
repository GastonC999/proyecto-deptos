package com.gastoncastro.departamentos.service;

import com.gastoncastro.departamentos.modelo.Departamento;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeptosService {

    private List<Departamento> deptos = new ArrayList<>();


    public List<Departamento> getDeptos(){
        return deptos;
    }
}
