package com.example.siontravel.Model.Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "reservas")
public class Reservas implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre_reserva;
    private String apellido_reserva;
    private String documento_tipo;
    private String numero_documento;
    private String tipo_reserva;
    private String fecha_salida;
    private String fehca_llegada;
    @ManyToOne
    @JoinColumn(name = "id_from")
    private Areas areas_from;
    @ManyToOne
    @JoinColumn(name = "id_to")
    private Areas areas_to;
    private int adulto_numero;
    private int infante_numero;
    private Integer valor_total;
    private Date fecha_creacion_reserva;
    private String numero_reserva;
    private String nota_reserva;
    private String discapacidad;
    private String tipo_discapacidad;

    @OneToOne
    @JoinColumn(name="id_bus")
    private Buses id_bus;

    @OneToOne
    @JoinColumn(name="id")
    private Rutas id_ruta_to;
    
    @OneToOne
    @JoinColumn(name="id")
    private Rutas id_ruta_from;

    @OneToOne
    @JoinColumn(name = "id_bus_roundtrip")
    private Buses id_bus_roundtrip;
    
    private List<?> listaPrecios;

    public Reservas() {
    }

    
    public Reservas(int id, String nombre_reserva, String apellido_reserva, String documento_tipo,
			String numero_documento, String tipo_reserva, String fecha_salida, String fehca_llegada, Areas areas_from,
			Areas areas_to, int adulto_numero, int infante_numero, Integer valor_total, Date fecha_creacion_reserva,
			String numero_reserva, String nota_reserva, String discapacidad, String tipo_discapacidad, Buses id_bus,
			Rutas id_ruta_to, Rutas id_ruta_from, Buses id_bus_roundtrip) {
		super();
		this.id = id;
		this.nombre_reserva = nombre_reserva;
		this.apellido_reserva = apellido_reserva;
		this.documento_tipo = documento_tipo;
		this.numero_documento = numero_documento;
		this.tipo_reserva = tipo_reserva;
		this.fecha_salida = fecha_salida;
		this.fehca_llegada = fehca_llegada;
		this.areas_from = areas_from;
		this.areas_to = areas_to;
		this.adulto_numero = adulto_numero;
		this.infante_numero = infante_numero;
		this.valor_total = valor_total;
		this.fecha_creacion_reserva = fecha_creacion_reserva;
		this.numero_reserva = numero_reserva;
		this.nota_reserva = nota_reserva;
		this.discapacidad = discapacidad;
		this.tipo_discapacidad = tipo_discapacidad;
		this.id_bus = id_bus;
		this.id_ruta_to = id_ruta_to;
		this.id_ruta_from = id_ruta_from;
		this.id_bus_roundtrip = id_bus_roundtrip;
	}


	public int getId() {
        return id;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Buses getId_bus_roundtrip() {
        return id_bus_roundtrip;
    }

    public void setId_bus_roundtrip(Buses id_bus_roundtrip) {
        this.id_bus_roundtrip = id_bus_roundtrip;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_reserva() {
        return nombre_reserva;
    }

    public void setNombre_reserva(String nombre_reserva) {
        this.nombre_reserva = nombre_reserva;
    }

    public String getApellido_reserva() {
        return apellido_reserva;
    }

    public void setApellido_reserva(String apellido_reserva) {
        this.apellido_reserva = apellido_reserva;
    }

    public String getDocumento_tipo() {
        return documento_tipo;
    }

    public void setDocumento_tipo(String documento_tipo) {
        this.documento_tipo = documento_tipo;
    }

    public String getNumero_documento() {
        return numero_documento;
    }

    public void setNumero_documento(String numero_documento) {
        this.numero_documento = numero_documento;
    }

    public String getTipo_reserva() {
        return tipo_reserva;
    }

    public void setTipo_reserva(String tipo_reserva) {
        this.tipo_reserva = tipo_reserva;
    }

    public String getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(String fecha_salida) {
        this.fecha_salida = fecha_salida;
    }

    public String getFehca_llegada() {
        return fehca_llegada;
    }

    public void setFehca_llegada(String fehca_llegada) {
        this.fehca_llegada = fehca_llegada;
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

    public int getAdulto_numero() {
        return adulto_numero;
    }

    public void setAdulto_numero(int adulto_numero) {
        this.adulto_numero = adulto_numero;
    }

    public int getInfante_numero() {
        return infante_numero;
    }

    public void setInfante_numero(int infante_numero) {
        this.infante_numero = infante_numero;
    }

    public Integer getValor_total() {
        return valor_total;
    }

    public void setValor_total(Integer integer) {
        this.valor_total = integer;
    }

    public Date getFecha_creacion_reserva() {
        return fecha_creacion_reserva;
    }

    public void setFecha_creacion_reserva(Date fecha_creacion_reserva) {
        this.fecha_creacion_reserva = fecha_creacion_reserva;
    }

    public String getNumero_reserva() {
        return numero_reserva;
    }

    public void setNumero_reserva(String numero_reserva) {
        this.numero_reserva = numero_reserva;
    }

    public String getNota_reserva() {
        return nota_reserva;
    }

    public void setNota_reserva(String nota_reserva) {
        this.nota_reserva = nota_reserva;
    }

    public String getDiscapacidad() {
        return discapacidad;
    }

    public void setDiscapacidad(String discapacidad) {
        this.discapacidad = discapacidad;
    }

    public String getTipo_discapacidad() {
        return tipo_discapacidad;
    }

    public void setTipo_discapacidad(String tipo_discapacidad) {
        this.tipo_discapacidad = tipo_discapacidad;
    }

    public Buses getId_bus() {
        return id_bus;
    }

    public void setId_bus(Buses id_bus) {
        this.id_bus = id_bus;
    }

	public Rutas getId_ruta_to() {
		return id_ruta_to;
	}

	public void setId_ruta_to(Rutas id_ruta_to) {
		this.id_ruta_to = id_ruta_to;
	}

	public Rutas getId_ruta_from() {
		return id_ruta_from;
	}

	public void setId_ruta_from(Rutas id_ruta_from) {
		this.id_ruta_from = id_ruta_from;
	}


	public List<?> getListaPrecios() {
		return listaPrecios;
	}

	public void setListaPrecios(Map<String, Integer> listaPrecios) {
		this.listaPrecios = (List<?>) listaPrecios;
	}

    
}
