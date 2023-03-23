package com.example.siontravel.Model.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "rutas")
@Data
@Builder @AllArgsConstructor @NoArgsConstructor
public class Rutas implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_from")
    private Areas id_from;
    @ManyToOne
    @JoinColumn(name = "id_to")
    private Areas id_to;
    @ManyToOne
    @JoinColumn(name = "id_bus")
    private Buses id_bus;
    private String precio_adulto;
    private String precio_infante;
    private String precio_equipaje;
    private String fecha_inicio;
    private String fecha_final;
    private int habilitado;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Areas getAreas_from() {
        return id_from;
    }

    public void setAreas_from(Areas id_from) {
        this.id_from = id_from;
    }

    public Areas getAreas_to() {
        return id_to;
    }

    public void setAreas_to(Areas id_to) {
        this.id_to = id_to;
    }

    public Buses getId_bus() {
        return id_bus;
    }

    public void setId_bus(Buses id_bus) {
        this.id_bus = id_bus;
    }

    public String getPrecio_adulto() {
        return precio_adulto;
    }

    public void setPrecio_adulto(String precio_adulto) {
        this.precio_adulto = precio_adulto;
    }

    public String getPrecio_infante() {
        return precio_infante;
    }

    public void setPrecio_infante(String precio_infante) {
        this.precio_infante = precio_infante;
    }

    public String getPrecio_equipaje() {
        return precio_equipaje;
    }

    public void setPrecio_equipaje(String precio_equipaje) {
        this.precio_equipaje = precio_equipaje;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFecha_final() {
        return fecha_final;
    }

    public void setFecha_final(String fecha_final) {
        this.fecha_final = fecha_final;
    }

    public int getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(int habilitado) {
        this.habilitado = habilitado;
    }

}
