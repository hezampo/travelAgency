package com.example.siontravel.Controller;

import java.net.SocketOption;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.siontravel.Model.Entity.Areas;
import com.example.siontravel.Model.Entity.Reservas;
import com.example.siontravel.Model.Services.AreasInterfacesServices;
import com.example.siontravel.Model.Services.ReservasInterfacesServices;
import reactor.core.publisher.Flux;

@Controller
@RequestMapping("/admin/reservas")
public class ReservasController {

    @Autowired
    private ReservasInterfacesServices reservasInterfacesServices;
    
    @Autowired
    private AreasInterfacesServices areasInterfacesServices;

    @GetMapping("/")
    public String listar(Model model){
        List<Reservas> listaReservas = reservasInterfacesServices.listar();
        model.addAttribute("titulo", "Lista de Reservas");
        model.addAttribute("reservas", listaReservas);
        return "admin/reservas/reservasListar";
    }

    @GetMapping("/crear")
    public String crear(Model model){
    	List<Areas> listaAreas = areasInterfacesServices.listar();
        model.addAttribute("titulo", "Crear una nueva Reserva");
        Reservas reservas = new Reservas();
        model.addAttribute("reservas", reservas);
        model.addAttribute("btntitulo", "Crear Reserva");
        model.addAttribute("areasLista", listaAreas);
        return "/admin/reservas/reservasAgregar";
    }

}
