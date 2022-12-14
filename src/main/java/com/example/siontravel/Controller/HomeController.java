package com.example.siontravel.Controller;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.siontravel.Model.Entity.Areas;
import com.example.siontravel.Model.Entity.Reservas;
import com.example.siontravel.Model.Services.AreasInterfacesServices;
import com.example.siontravel.Model.Services.ReservasInterfacesServices;
import com.example.siontravel.Util.Constantes;


@Controller
public class HomeController {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    List<?> onwaytrip, roundtrip;

    @Autowired
    private AreasInterfacesServices areasInterfacesServices;
    
    @Autowired
    private ReservasInterfacesServices reservasInterfacesServices;
   	
    @Autowired
    HttpServletRequest request; 


    @GetMapping("/")
    public String index(Model model){
        List<Areas> listaAreas = areasInterfacesServices.listar();
        Reservas reservas = new Reservas();
        model.addAttribute("areasLista", listaAreas);
        model.addAttribute("reservas", reservas);
        model.addAttribute("titulo", "Formulario de Booking");
        return "home";
    }
	
    @PostMapping("/booking")
    public String booking(@ModelAttribute Reservas reservas,Model model) {
        model.addAttribute("titulo", "Lista de rutas para su fecha de viaje");
        model.addAttribute("reservas", reservas);
        List<?> listaFrom = onWayTrip(reservas.getAreas_from().getId(), reservas.getAreas_to().getId(), reservas.getFecha_salida());
        model.addAttribute("onewaytrip", listaFrom);
        if(Constantes.ROUND_TRIP.equals(reservas.getTipo_reserva())) {
        	List<?> listaTo = roundTrip(reservas.getAreas_from().getId(), reservas.getAreas_to().getId(), reservas.getFehca_llegada());
        	model.addAttribute("roundtrip", listaTo);
        }
        return "/booking";
    }

    @PostMapping("/confirm")
    public String bookingConfirm(@ModelAttribute Reservas reservas,Model model){
        String numero_reserva = numeroDeReserva();
        Map<String, Integer> listaPrecios = calculoDePrecioParaReserva(reservas);
        model.addAttribute("titulo", "Estos son los datos de su reserva con # de reserva - "+numero_reserva);
        reservas.setNumero_reserva(numero_reserva);
        model.addAttribute("reservas", reservas);
        model.addAttribute("listaPrecios", listaPrecios);
        
        return "/confirm";
    }
    
    public Map<String, Integer> calculoDePrecioParaReserva(Reservas reservas){
    	int precio_adultoIda = Integer.parseInt(reservas.getId_ruta_from().getPrecio_adulto());
    	int precio_infanteIda = Integer.parseInt(reservas.getId_ruta_from().getPrecio_infante());
    	int precio_adultoRegreso = Integer.parseInt(reservas.getId_ruta_to().getPrecio_adulto());
    	int precio_infanteRegreso = Integer.parseInt(reservas.getId_ruta_to().getPrecio_infante());
    	int precioTotalAdultoIda = reservas.getAdulto_numero()*precio_adultoIda;
    	int precioTotalInfanteIda = reservas.getInfante_numero()*precio_infanteIda;
    	int precioTotalAdultoRegreso = reservas.getAdulto_numero()*precio_adultoRegreso;
    	int precioTotalInfantRegreso = reservas.getInfante_numero()*precio_infanteRegreso;
    	int precioTotalAdulto = (precioTotalAdultoIda + precioTotalAdultoRegreso);
    	int precioTotlInfante =(precioTotalInfanteIda + precioTotalInfantRegreso);
    	int precioTotal = (precioTotalAdultoIda + precioTotalInfanteIda + precioTotalAdultoRegreso + precioTotalInfantRegreso); 
    	HashMap<String, Integer> listaPrecios = new HashMap<>();
    	listaPrecios.put("precio_adultoiIda", precio_adultoIda);
    	listaPrecios.put("precio_infanteIda", precio_infanteIda);
    	listaPrecios.put("precio_adultoRegreso", precio_adultoRegreso);
    	listaPrecios.put("precio_infanteRegreso", precio_infanteRegreso);
    	listaPrecios.put("precioTotalAdultoIda", precioTotalAdultoIda);
    	listaPrecios.put("precioTotalInfanteIda", precioTotalInfanteIda);
    	listaPrecios.put("precioTotalAdultoRegreso", precioTotalAdultoRegreso);
    	listaPrecios.put("precioTotalInfantRegreso", precioTotalInfantRegreso);
    	listaPrecios.put("precioTotalAdulto", precioTotalAdulto);
    	listaPrecios.put("precioTotalInfante", precioTotlInfante);
    	listaPrecios.put("precioTotal", precioTotal);
    	return listaPrecios;
    }
    
    public String numeroDeReserva() {
    	String numeroReserva = "";
    	Calendar calendario = Calendar.getInstance();
    	int anio = calendario.get(Calendar.YEAR);
    	int mes = calendario.get(Calendar.MONTH);
    	int dia = calendario.get(Calendar.DAY_OF_MONTH);
        int hora = calendario.get(Calendar.HOUR_OF_DAY);
        int minuto = calendario.get(Calendar.MINUTE);
        int segundo = calendario.get(Calendar.SECOND);
        numeroReserva = "ST"+anio+mes+dia+hora+minuto+segundo;
		return numeroReserva;
    }
    
    @PostMapping("/guardarReserva")
    public String guardarReserva(@ModelAttribute Reservas reservas){
    	reservas.setFecha_creacion_reserva(new Date());
        reservas.setDiscapacidad("ninguna");
        reservas.setNota_reserva("reservas hecha desde la pagina web");
        reservasInterfacesServices.guardar(reservas);
        return "redirect:/";
    }
    
    public List<?> onWayTrip(int id_from, int id_to, String fecha_salida){
        var sql = "SELECT DISTINCT r.id AS id_ruta, r.precio_adulto, r.precio_infante, r.precio_equipaje, a.nombre AS origen, a1.nombre AS destino, b.hora_salida, b.hora_llegada, b.id AS id_bus, b.bus, b.id_from, b1.id_to FROM rutas r LEFT JOIN area a ON (r.id_from = a.id) LEFT JOIN area a1 ON (r.id_to = a1.id) LEFT JOIN bus b ON (a.id = b.id_from) LEFT JOIN bus b1 ON (a1.id = b1.id_to) WHERE r.id_from = "+id_from+" AND r.id_to = "+id_to+" AND b.id_from = "+id_from+" AND b.id_to = "+id_to+" AND r.fecha_inicio <= '"+fecha_salida+"' AND r.fecha_final >= '"+fecha_salida+"' ";
        onwaytrip = this.jdbcTemplate.queryForList(sql);
		return onwaytrip;
    }

    public List<?> roundTrip(int id_from, int id_to, String fecha_llegada){
        var sql = "SELECT DISTINCT r.id AS id_ruta, r.precio_adulto, r.precio_infante, r.precio_equipaje, a.nombre AS origen, a1.nombre AS destino, b.hora_salida, b.hora_llegada, b.id AS id_bus, b.bus, b.id_from, b1.id_to FROM rutas r LEFT JOIN area a ON (r.id_from = a.id) LEFT JOIN area a1 ON (r.id_to = a1.id) LEFT JOIN bus b ON (a.id = b.id_from) LEFT JOIN bus b1 ON (a1.id = b1.id_to) WHERE r.id_to = "+id_from+" AND r.id_from = "+id_to+" AND b.id_to = "+id_from+" AND b.id_from = "+id_to+" AND r.fecha_inicio <= '"+fecha_llegada+"' AND r.fecha_final >= '"+fecha_llegada+"' ";
        roundtrip = this.jdbcTemplate.queryForList(sql);
        return roundtrip;
    }

    @GetMapping("/admin/inicio")
    public String indexAdmin(){
        return "admin/inicio";
    }

}
