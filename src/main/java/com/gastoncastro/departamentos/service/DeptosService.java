package com.gastoncastro.departamentos.service;

import com.gastoncastro.departamentos.modelo.entity.Departamento;
import com.gastoncastro.departamentos.modelo.dto.DepartamentoDto;
import com.gastoncastro.departamentos.repositories.DepartamentoRepository;
import jakarta.persistence.EntityManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;





@Service
public class DeptosService implements EntityService<DepartamentoDto, Departamento> {

    private static final Logger log = LogManager.getLogger(DeptosService.class);
    @Autowired
    private EntityManager em;

    @Autowired
    private DepartamentoRepository repository;

//    public List<Departamento> getListEntidades(String nombreSubstring){
//        if (nombreSubstring!=null){
//            return repository.listar().stream()
//                    .filter(d -> (d.getDireccion() + " " + d.getNumero()).startsWith(nombreSubstring))
//                    .collect(Collectors.toList());
//        }else {
//            return repository.listar();
//        }
//    }

    public List<Departamento> getListEntidades() {
        return repository.listar();
    }

    @Override
    public Departamento porId(Long id) {
        return repository.listar().stream().filter(d ->
                        d.getId().equals(id)).findAny()
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,
                                String.format("Departamento inexistente")));
    }
    @Override
    public Departamento guardar(DepartamentoDto departamentoDto) {

        log.info("Comienza el metodo guardar");

        Departamento departamento = new Departamento();
        departamento.setPropietario(departamentoDto.getPropietario());
        departamento.setDireccion(departamentoDto.getDireccion());
        departamento.setNumero(departamentoDto.getNumero());
        departamento.setPiso(departamentoDto.getPiso());

        String nombre = departamento.getDireccion();
        String nombre2 = departamento.getNumero();
        boolean repo = repository.listar().stream().anyMatch(d ->
                d.getDireccion().equals(nombre));
        boolean numeros = repository.listar().stream().anyMatch(d ->
                d.getNumero().equals(nombre2));
        if (repo) {
            if (numeros) {
                log.info("El departamento ya existe");
                throw new ResponseStatusException(HttpStatus.CONFLICT,
                        String.format("El departamento ya existe"));
            }
        }
        try{
            em.getTransaction().begin();
            repository.guardar(departamento);
            em.getTransaction().commit();
            log.debug("Aqui puede pasar un error");
        }catch (Exception e){
            log.error("No se cargan los datos, hace rollback");
            em.getTransaction().rollback();
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                    String.format("No se almaceno"));
        }
        return departamento;
    }


    public Departamento updateDepto(Departamento departamento, long id) {
        Departamento deptoToBeUpdate = porId(id);
        deptoToBeUpdate.setPropietario(departamento.getPropietario());
        deptoToBeUpdate.setDireccion(departamento.getDireccion());
        deptoToBeUpdate.setNumero(departamento.getNumero());
        deptoToBeUpdate.setPiso(departamento.getPiso());
        return deptoToBeUpdate;
    }


    @Override
    public void eliminar(Long id) {
        try {
            em.getTransaction().begin();
            repository.eliminar(id);
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}