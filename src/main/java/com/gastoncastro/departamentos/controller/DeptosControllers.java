package com.gastoncastro.departamentos.controller;

import com.gastoncastro.departamentos.modelo.Departamento;
import com.gastoncastro.departamentos.service.DeptosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/deptos")
public class DeptosControllers {

    @Autowired
    private DeptosService deptosService;
    @GetMapping
    public ResponseEntity<List<Departamento>> getDeptos(){
        return new ResponseEntity<List<Departamento>> (deptosService.getDeptos(), HttpStatus.OK);
    }

}
