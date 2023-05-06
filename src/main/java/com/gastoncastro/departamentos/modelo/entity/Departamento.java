package com.gastoncastro.departamentos.modelo.entity;


import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name="departamentos")
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id;
    @ManyToOne
    private Persona propietario;
    private String direccion;
    private String numero;
    private String piso;

    public Departamento() {
    }

    public Departamento(Long id, Persona propietario, String direccion, String numero, String piso) {
        this.id = id;
        this.propietario = propietario;
        this.direccion = direccion;
        this.numero = numero;
        this.piso = piso;
    }

    public Persona getPropietario() {
        return propietario;
    }

    public void setPropietario(Persona propietario) {
        this.propietario = propietario;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Departamento departamento = (Departamento) o;
        return Objects.equals(id, departamento.id) && Objects.equals(propietario, departamento.propietario) && Objects.equals(direccion, departamento.direccion) && Objects.equals(numero, departamento.numero) && Objects.equals(piso, departamento.piso);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, propietario, direccion, numero, piso);
    }

    @Override
    public String toString() {
        return "Departamento{" +
                "nombre='" + propietario + '\'' +
                ", direccion='" + direccion + '\'' +
                ", numero='" + numero + '\'' +
                ", piso='" + piso + '\'' +
                ", id=" + id +
                '}';
    }
}
