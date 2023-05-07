package com.gastoncastro.departamentos.service;

import com.gastoncastro.departamentos.modelo.dto.PersonaDto;
import com.gastoncastro.departamentos.modelo.entity.Departamento;
import com.gastoncastro.departamentos.modelo.entity.Persona;
import com.gastoncastro.departamentos.repositories.PersonaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Transient;
import jakarta.transaction.Transactional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PersonaService implements EntityService<PersonaDto, Persona> {
    private static final Logger log = LogManager.getLogger(PersonaService.class);

    @Autowired
    private EntityManager em;

    @Autowired
    private PersonaRepository repository;

    @Override
    public List<Persona> getListEntidades() {
        return repository.listar();
    }

    @Override
    public Persona porId(Long id) {
        return repository.listar().stream().filter(p ->
                p.getId().equals(id)).findAny()
                .orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND,
                        String.format("Departamento inexistente")));
    }

    @Override
    public Persona guardar(PersonaDto personaDto) {

        Persona persona = new Persona();
        persona.setNombre(personaDto.getNombre());
        persona.setApellido(personaDto.getApellido());
        persona.setFechaNacimiento(personaDto.getFechaNacimiento());
        persona.setTipoDni(personaDto.getTipoDni());
        persona.setDni(personaDto.getDni());

        Long perDni = persona.getDni();
        boolean metodo = repository.listar().stream().anyMatch(p ->
                p.getDni().equals(perDni));

        if (metodo){
            throw new ResponseStatusException(HttpStatus.CONFLICT,
                    String.format("La persona ya existe"));
    }
        try {
            em.getTransaction().begin();
            repository.guardar(persona);
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                    String.format("No se almaceno"));
        }
        return persona;
    }
    public Persona updatePersona(Persona persona, long id) {
        Persona personaToBeUpdate = porId(id);
        personaToBeUpdate.setNombre(persona.getNombre());
        personaToBeUpdate.setApellido(persona.getApellido());
        personaToBeUpdate.setFechaNacimiento(persona.getFechaNacimiento());
        personaToBeUpdate.setTipoDni(persona.getTipoDni());
        personaToBeUpdate.setDni(persona.getDni());
        return personaToBeUpdate;
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        em.remove(porId(id));

    }
}
