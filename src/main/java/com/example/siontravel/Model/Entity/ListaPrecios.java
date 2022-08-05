package com.example.siontravel.Model.Entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "preciosReserva")
public class ListaPrecios implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	public Integer precio_adultoIda;
	public Integer precio_adultoRegreso;
	public Integer precio_infanteIda;
	public Integer precio_infanteRegreso;
	public Integer precio_total;
	public String numero_reserva;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Integer getPrecio_adultoIda() {
		return precio_adultoIda;
	}
	public void setPrecio_adultoIda(Integer precio_adultoIda) {
		this.precio_adultoIda = precio_adultoIda;
	}
	public Integer getPrecio_adultoRegreso() {
		return precio_adultoRegreso;
	}
	public void setPrecio_adultoRegreso(Integer precio_adultoRegreso) {
		this.precio_adultoRegreso = precio_adultoRegreso;
	}
	public Integer getPrecio_infanteIda() {
		return precio_infanteIda;
	}
	public void setPrecio_infanteIda(Integer precio_infanteIda) {
		this.precio_infanteIda = precio_infanteIda;
	}
	public Integer getPrecio_infanteRegreso() {
		return precio_infanteRegreso;
	}
	public void setPrecio_infanteRegreso(Integer precio_infanteRegreso) {
		this.precio_infanteRegreso = precio_infanteRegreso;
	}
	public Integer getPrecio_total() {
		return precio_total;
	}
	public void setPrecio_total(Integer precio_total) {
		this.precio_total = precio_total;
	}
	public String getNumero_reserva() {
		return numero_reserva;
	}
	public void setNumero_reserva(String numero_reserva) {
		this.numero_reserva = numero_reserva;
	}

}
