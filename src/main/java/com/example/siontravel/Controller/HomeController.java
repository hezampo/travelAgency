package com.example.siontravel.Controller;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import com.example.siontravel.Model.Entity.Buses;
import com.example.siontravel.Model.Repository.ReservasRepository;
import com.example.siontravel.Model.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.siontravel.Model.Entity.Areas;
import com.example.siontravel.Model.Entity.Reservas;
import com.example.siontravel.Util.Constantes;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    List<?> onwaytrip, roundtrip;

    @Autowired
    private AreasInterfacesServices areasInterfacesServices;

    @Autowired
    private RutasInterfacesServices rutasInterfacesServices;
    
    @Autowired
    private ReservasInterfacesServices reservasInterfacesServices;

    @Autowired
    private BusInterfacesServices busInterfacesServices;

   
    @GetMapping("/")
    public String index(Model model){
        List<Areas> listaAreas = areasInterfacesServices.listarAreasHabilitadas();
        Reservas reservas = new Reservas();
        model.addAttribute("areasLista", listaAreas);
        model.addAttribute("reservas", reservas);
        model.addAttribute("flag", true);
        model.addAttribute("titulo", "Formulario de Booking");
        return "/home";
    }

    @RequestMapping("/login")
    public String indexAdmin(Model model){
        return "admin/login/login";
    }
	
    @PostMapping("/booking")
    public String booking(@ModelAttribute Reservas reservas,Model model) {
        model.addAttribute("titulo", "Lista de rutas para su fecha de viaje");
        model.addAttribute("reservas", reservas);
        int totalPersonasReserva = (reservas.getAdulto_numero() + reservas.getInfante_numero());
        List<?> listaFrom = rutasInterfacesServices.onWayTrip(reservas.getAreas_from().getId(), reservas.getAreas_to().getId(), reservas.getFecha_salida(), totalPersonasReserva);
        model.addAttribute("onewaytrip", listaFrom);
        if(Constantes.ROUND_TRIP.equals(reservas.getTipo_reserva())) {
        	List<?> listaTo = rutasInterfacesServices.roundTrip(reservas.getAreas_from().getId(), reservas.getAreas_to().getId(), reservas.getFehca_llegada(), totalPersonasReserva);
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
        try {
            reservasInterfacesServices.guardar(reservas);
            List<Reservas> reservaEncontrada = reservasInterfacesServices.obtenerReservaDesdeDB(reservas);
            if(!reservaEncontrada.isEmpty() && reservaEncontrada.size() > 0){
                this.descontarPasajerosdeBus((reservas.getId_bus().getCapacidad() -(reservas.getAdulto_numero() + reservas.getInfante_numero())), reservas.getId_bus());
                if (Constantes.ROUND_TRIP.equals(reservas.getTipo_reserva())){
                    this.descontarPasajerosdeBus((reservas.getId_bus_roundtrip().getCapacidad() - (reservas.getAdulto_numero() + reservas.getInfante_numero())), reservas.getId_bus_roundtrip());
                }
            }
            return "redirect:/";
        }catch (Exception e){
            System.out.println("error ->"+e);
            return null;
        }
    }

    public void descontarPasajerosdeBus(int totalPasajeros, Buses id_bus){
        busInterfacesServices.actualizarCapacidadBus(totalPasajeros, id_bus.getId());
    }

    @GetMapping({"/admin/inicio","/admin"})
    public String indexAdmin(){
        return "redirect:/admin/areas/";
    }

    @GetMapping("/login")
    public String indexLogin() {
        return "login";
    }

    @GetMapping("/menu")
    public String menu() {
        return "menu";
    }

    @GetMapping("/user")
    public String user() {
        return "user";
    }

}
