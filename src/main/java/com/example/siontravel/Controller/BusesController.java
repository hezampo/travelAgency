package com.example.siontravel.Controller;

import com.example.siontravel.Model.Entity.Areas;
import com.example.siontravel.Model.Entity.Buses;
import com.example.siontravel.Model.Entity.Rutas;
import com.example.siontravel.Model.Services.BusInterfacesServices;
import com.example.siontravel.Model.Services.CiudadInterfacesServices;
import com.example.siontravel.Model.Services.RutasInterfacesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/buses")
public class BusesController {

    @Autowired
    private BusInterfacesServices busInterfacesServices;

    @Autowired
    private CiudadInterfacesServices ciudadInterfacesServices;

    @Autowired
    private RutasInterfacesServices rutasInterfacesServices;

    @GetMapping("/")
    public String listar(Model model){
        List<Buses> listarBuses = busInterfacesServices.listar();
        model.addAttribute("titulo", "Lista de Buses");
        model.addAttribute("buses", listarBuses);
        return "/admin/buses/busListar";
    }

    @GetMapping("/crear")
    public String crear(Model model){
        List<Areas> listaAreas = ciudadInterfacesServices.listaAreas();
        List<Rutas> listaTarifarios = rutasInterfacesServices.listar();
        model.addAttribute("titulo", "Crear un nuevo Bus");
        Buses buses = new Buses();
        model.addAttribute("buses", buses);
        model.addAttribute("btntitulo", "Agregar el Bus");
        model.addAttribute("areasLista", listaAreas);
        model.addAttribute("tarifarioLista", listaTarifarios);
        return "/admin/buses/busAgregar";
    }

    @PostMapping("/save")
    public String guarddar(@ModelAttribute Buses buses){
        busInterfacesServices.guardar(buses);
        return "redirect:/admin/buses/";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable("id") int id, Model model){
        List<Areas> listaAreas = ciudadInterfacesServices.listaAreas();
        List<Rutas> listaTarifarios = rutasInterfacesServices.listar();
        model.addAttribute("titulo", "Editar el Bus");
        Buses buses = busInterfacesServices.buscarById(id);
        model.addAttribute("buses", buses);
        model.addAttribute("btntitulo", "Editar el Bus");
        model.addAttribute("areasLista", listaAreas);
        model.addAttribute("tarifarioLista", listaTarifarios);
        return "/admin/buses/busAgregar";
    }
}
