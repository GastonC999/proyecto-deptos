package com.gastoncastro.departamentos.modelo;

public class departamento {

    String nombre;
    String direccion;
    String numero;
    String piso;

    public departamento(String nombre, String direccion, String numero, String piso) {
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

    @Override
    public String toString() {
        return "departamento{" +
                "nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", numero='" + numero + '\'' +
                ", piso='" + piso + '\'' +
                '}';
    }
}
