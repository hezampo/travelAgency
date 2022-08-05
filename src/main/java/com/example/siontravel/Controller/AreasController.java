package com.example.siontravel.Controller;

import com.example.siontravel.Model.Entity.Areas;
import com.example.siontravel.Model.Services.AreasInterfacesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/areas")
public class AreasController {

    @Autowired
    private AreasInterfacesServices areasInterfacesServices;

    @GetMapping("/")
    public String listar(Model model){
        List<Areas> listaAreas = areasInterfacesServices.listar();
        model.addAttribute("titulo", "Lista de Areas");
        model.addAttribute("areas", listaAreas);
        return "/admin/areas/areaListar";
    }

    @GetMapping("/crear")
    public String crear(Model model){
        model.addAttribute("titulo", "Crear una nueva Ciudad");
        Areas areas = new Areas();
        model.addAttribute("btntitulo", "Crear Ciudad");
        model.addAttribute("areas", areas);
        return "/admin/areas/areaAgregar";
    }

    @PostMapping("/save")
    public String guardar(@ModelAttribute Areas areas){
        areasInterfacesServices.guardar(areas);
        return "redirect:/admin/areas/";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable("id") int id, Model model){
        model.addAttribute("titulo", "Crear una nueva Ciudad");
        Areas areas = areasInterfacesServices.buscarById(id);
        model.addAttribute("btntitulo", "Editar Ciudad");
        model.addAttribute("areas", areas);
        return "/admin/areas/areaAgregar";
    }


}
