package com.gastoncastro.departamentos.modelo.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "personas")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private Date fechaNacimiento;
    private TipoDni tipoDni;
    private Long dni;
    @OneToMany(mappedBy = "propietario")
    private List<Departamento> departamentos;

    public Persona() {
    }

    public Persona(Long id, String nombre, String apellido, Date fechaNacimiento, TipoDni tipoDni, Long dni, List<Departamento> departamentos) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.tipoDni = tipoDni;
        this.dni = dni;
        this.departamentos = departamentos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public TipoDni getTipoDni() {
        return tipoDni;
    }

    public void setTipoDni(TipoDni tipoDni) {
        this.tipoDni = tipoDni;
    }

    public Long getDni() {
        return dni;
    }

    public void setDni(Long dni) {
        this.dni = dni;
    }

    public List<Departamento> getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(List<Departamento> departamentos) {
        this.departamentos = departamentos;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", tipoDni=" + tipoDni +
                ", dni=" + dni +
                ", departamentos=" + departamentos +
                '}';
    }
}
