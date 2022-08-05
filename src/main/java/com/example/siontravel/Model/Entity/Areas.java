package com.example.siontravel.Model.Entity;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "area")
public class Areas implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String direccion;
    private int habilitado;

    public Areas() {

    }

    public Areas(int id, String nombre, String direccion, int habilitado) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.habilitado = habilitado;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(int habilitado) {
        this.habilitado = habilitado;
    }

    @Override
    public String toString() {
        return "Areas{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", habilitado=" + habilitado +
                '}';
    }
}
