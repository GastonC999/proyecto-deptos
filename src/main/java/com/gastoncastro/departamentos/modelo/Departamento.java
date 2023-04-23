package com.gastoncastro.departamentos.modelo;

import jakarta.persistence.*;

@Entity
@Table(name="departamentos")
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private   Long  id;
    private String nombre;
    private String direccion;
    private  String numero;
    private  String piso;

    public Departamento() {
    }

    public Departamento(String nombre, String direccion, String numero, String piso) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.numero = numero;
        this.piso = piso;
        this.id = id;
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
