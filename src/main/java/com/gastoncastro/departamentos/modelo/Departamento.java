package com.gastoncastro.departamentos.modelo;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name="departamentos")
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long  id;
     String nombre;
     String direccion;
      String numero;
      String piso;

    public Departamento() {
    }

    public Departamento(Long id, String nombre, String direccion, String numero, String piso) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.numero = numero;
        this.piso = piso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
        return Objects.equals(id, departamento.id) && Objects.equals(nombre, departamento.nombre) && Objects.equals(direccion, departamento.direccion) && Objects.equals(numero, departamento.numero) && Objects.equals(piso, departamento.piso);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, direccion, numero, piso);
    }

    @Override
    public String toString() {
        return "Departamento{" +
                "nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", numero='" + numero + '\'' +
                ", piso='" + piso + '\'' +
                ", id=" + id +
                '}';
    }
}
