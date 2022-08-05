package com.example.siontravel.Controller;

import com.example.siontravel.Model.Entity.Areas;
import com.example.siontravel.Model.Entity.Rutas;
import com.example.siontravel.Model.Services.AreasInterfacesServices;
import com.example.siontravel.Model.Services.RutasInterfacesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/v1/api")
public class ApiController {
    @Autowired
    private RutasInterfacesServices rutasInterfacesServices;
    @Autowired
    private AreasInterfacesServices areasInterfacesServices;

    @GetMapping("/getRutas")
    public List<Rutas> getRutas(){
        List<Rutas>listadoRutas =  rutasInterfacesServices.listar();
        return listadoRutas;
    }

    @GetMapping("/load/{id}")
    public List<?> getRutaForIdArea(@PathVariable("id") int id){
        List<?> getRutaForIdArea = areasInterfacesServices.listaRutas(id);
        return getRutaForIdArea;
    }

    @GetMapping("/getAreas")
    public List<Areas> getAreas(){
        List<Areas>listadoAreas =  areasInterfacesServices.listar();
        return listadoAreas;
    }

    @GetMapping("/getRutasByAreas/{id}")
    public List<Rutas> getRutasByArea(@PathVariable("id") int id) {
        List<Rutas> listadoRutasByAreas = rutasInterfacesServices.listar();
        return listadoRutasByAreas;
    }
}
