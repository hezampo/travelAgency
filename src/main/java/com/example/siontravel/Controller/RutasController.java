package com.example.siontravel.Controller;

import com.example.siontravel.Model.Entity.Areas;
import com.example.siontravel.Model.Entity.Rutas;
import com.example.siontravel.Model.Services.CiudadInterfacesServices;
import com.example.siontravel.Model.Services.RutasInterfacesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/rutas")
public class RutasController {

    @Autowired
    private RutasInterfacesServices rutasInterfacesServices;
    @Autowired
    private CiudadInterfacesServices ciudadInterfacesServices;

    @GetMapping("/")
    public String listar(Model model){
        List<Rutas> listarRutas = rutasInterfacesServices.listar();
        model.addAttribute("titulo", "Lista de Rutas");
        model.addAttribute("rutas", listarRutas);
        return "admin/rutas/rutasListar";
    }

    @GetMapping("/crear")
    public String crear(Model model){
        List<Areas> listaAreas = ciudadInterfacesServices.listaAreas();
        model.addAttribute("titulo", "Crear una nueva Ruta");
        Rutas rutas = new Rutas();
        model.addAttribute("rutas", rutas);
        model.addAttribute("btntitulo", "Crear Ruta");
        model.addAttribute("areasLista", listaAreas);
        return "/admin/rutas/rutasAgregar";
    }

    @PostMapping("/save")
    public String guarddar(@ModelAttribute Rutas rutas){
        rutasInterfacesServices.guardar(rutas);
        return "redirect:/admin/rutas/";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable("id") int id, Model model){
        List<Areas> listaAreas = ciudadInterfacesServices.listaAreas();
        model.addAttribute("titulo", "Editar la ruta");
        Rutas rutas = rutasInterfacesServices.buscarById(id);
        model.addAttribute("rutas", rutas);
        model.addAttribute("btntitulo", "Editar Ruta");
        model.addAttribute("areasLista", listaAreas);
        return "/admin/rutas/rutasAgregar";
    }
}
