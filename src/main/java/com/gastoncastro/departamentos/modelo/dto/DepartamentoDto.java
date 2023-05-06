package com.gastoncastro.departamentos.modelo.dto;

import com.gastoncastro.departamentos.modelo.entity.Persona;

public class DepartamentoDto {

    private Persona propietario;
    private String direccion;
    private String numero;
    private String piso;

    public Persona getPropietario() {
        return propietario;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getNumero() {
        return numero;
    }

    public String getPiso() {
        return piso;
    }
}
