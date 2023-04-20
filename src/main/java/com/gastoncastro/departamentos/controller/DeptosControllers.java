package com.gastoncastro.departamentos.controller;

import com.gastoncastro.departamentos.modelo.Departamento;
import com.gastoncastro.departamentos.service.DeptosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deptos")
public class DeptosControllers {

    @Autowired
    private DeptosService deptosService;

    @PostMapping
    public ResponseEntity<Departamento> CreateDepto (@RequestBody Departamento departamento){
        return new ResponseEntity<Departamento>(deptosService.CreateDepto(departamento),
        HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Departamento> getDeptoById(@PathVariable("id") long id){
        return new ResponseEntity<Departamento>(deptosService.getDeptoById(id), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<Departamento>> getDeptos(){
        return new ResponseEntity<List<Departamento>> (deptosService.getDeptos(), HttpStatus.OK);
    }

}
