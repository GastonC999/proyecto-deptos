package com.gastoncastro.departamentos.controller;

import com.gastoncastro.departamentos.modelo.Departamento;
import com.gastoncastro.departamentos.service.DeptosService;
import jakarta.ws.rs.QueryParam;
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
    public ResponseEntity<Departamento> guardarCandidato (@RequestBody Departamento departamento){
        return new ResponseEntity<Departamento>(deptosService.guardar(departamento),
        HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Departamento> getDeptoById(@PathVariable("id") long id){
        return new ResponseEntity<Departamento>(deptosService.porId(id), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<Departamento>> getDeptos(@QueryParam("departamentos") String departamento){
        return new ResponseEntity<List<Departamento>> (deptosService.getListEntidades(departamento), HttpStatus.OK);
    }

    @PutMapping(value= "/{id}")
    public ResponseEntity<Departamento> updateUser(@PathVariable("id") long id, @RequestBody Departamento departamento){
        return new ResponseEntity<Departamento>(deptosService.UpdateDepto(departamento, departamento.getId()), HttpStatus.OK);
    }
}
