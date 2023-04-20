package com.gastoncastro.departamentos.service;

import com.gastoncastro.departamentos.modelo.departamento;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class deptosService {

    private List<departamento> deptos = new ArrayList<>();


    public List<departamento> getDeptos(){
        return deptos;
    }
}
