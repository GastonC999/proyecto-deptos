package com.gastoncastro.departamentos.controller;

import com.gastoncastro.departamentos.modelo.dto.PersonaDto;
import com.gastoncastro.departamentos.modelo.entity.Persona;
import com.gastoncastro.departamentos.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personas")
public class PersonaControllers {
    @Autowired
    private PersonaService personaService;

    @PostMapping("/agregarPersona")
    public ResponseEntity<Persona> savePersona(@RequestBody PersonaDto personaDto){
        return new ResponseEntity<Persona>(personaService.guardar(personaDto),
                HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Persona> getPersonaById(@PathVariable("id") long id){
        return new ResponseEntity<Persona>(personaService.porId(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Persona>> getPersonas(){
        return new ResponseEntity<List<Persona>>(personaService.getListEntidades(), HttpStatus.OK);
    }

    @PutMapping(value = "/editar/{id}")
    public ResponseEntity<Persona> updatePersona (@PathVariable("id") long id, @RequestBody Persona persona){
        return new ResponseEntity<Persona>(personaService.updatePersona(persona, persona.getId()), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePersona(@PathVariable("id") Long id){
        personaService.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
