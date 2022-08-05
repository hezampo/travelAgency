package com.example.siontravel.Model.Entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "bus")
public class Buses implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String bus;
    private String conductor;
    private String compania;
    private int capacidad;
    @ManyToOne
    @JoinColumn(name = "id_from")
    private Areas areas_from;
    @ManyToOne
    @JoinColumn(name = "id_to")
    private Areas areas_to;
    private String hora_salida;
    private String hora_llegada;
    private int habilitado;


    public Buses() {
    }

    public Buses(int id, String bus, String conductor, String compania, int capacidad, Areas areas_from, Areas areas_to, String hora_salida, String hora_llegada, int habilitado) {
        this.id = id;
        this.bus = bus;
        this.conductor = conductor;
        this.compania = compania;
        this.capacidad = capacidad;
        this.areas_from = areas_from;
        this.areas_to = areas_to;
        this.hora_salida = hora_salida;
        this.hora_llegada = hora_llegada;
        this.habilitado = habilitado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBus() {
        return bus;
    }

    public void setBus(String bus) {
        this.bus = bus;
    }

    public String getConductor() {
        return conductor;
    }

    public void setConductor(String conductor) {
        this.conductor = conductor;
    }

    public String getCompania() {
        return compania;
    }

    public void setCompania(String compania) {
        this.compania = compania;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public Areas getAreas_from() {
        return areas_from;
    }

    public void setAreas_from(Areas areas_from) {
        this.areas_from = areas_from;
    }

    public Areas getAreas_to() {
        return areas_to;
    }

    public void setAreas_to(Areas areas_to) {
        this.areas_to = areas_to;
    }

    public String getHora_salida() {
        return hora_salida;
    }

    public void setHora_salida(String hora_salida) {
        this.hora_salida = hora_salida;
    }

    public String getHora_llegada() {
        return hora_llegada;
    }

    public void setHora_llegada(String hora_llegada) {
        this.hora_llegada = hora_llegada;
    }

    public int getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(int habilitado) {
        this.habilitado = habilitado;
    }
}
