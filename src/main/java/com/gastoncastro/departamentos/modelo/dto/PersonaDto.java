package com.gastoncastro.departamentos.modelo.dto;

import com.gastoncastro.departamentos.modelo.entity.Departamento;
import com.gastoncastro.departamentos.modelo.entity.TipoDni;

import java.util.Date;
import java.util.List;


public class PersonaDto {
    private String nombre;
    private String apellido;
    private Date fechaNacimiento;
    private TipoDni tipoDni;
    private Long dni;
    private List<DepartamentoDto> departamentos;

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public TipoDni getTipoDni() {
        return tipoDni;
    }

    public Long getDni() {
        return dni;
    }

    public List<DepartamentoDto> getDepartamentos() {
        return departamentos;
    }
}
