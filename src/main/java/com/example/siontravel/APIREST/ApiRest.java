package com.example.siontravel.APIREST;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.siontravel.Model.Entity.Rutas;
import com.example.siontravel.Model.Services.AreasInterfacesServices;
import com.example.siontravel.Model.Services.RutasInterfacesServices;

@RestController
@RequestMapping("/v1/apiRest")
public class ApiRest {
	@Autowired
    private RutasInterfacesServices rutasInterfacesServices;
	
	@Autowired
    private AreasInterfacesServices areasInterfacesServices;
	
	@GetMapping("/load/{id}")
    public List<?> getRutaForIdArea(@PathVariable("id") int id){
        List<?> getRutaForIdArea = areasInterfacesServices.listaRutas(id);
        return getRutaForIdArea;
    }
	
	@GetMapping("/getRutas")
    public List<Rutas> getRutas(){
        List<Rutas>listadoRutas =  rutasInterfacesServices.listar();
        return listadoRutas;
    }
	
	@GetMapping("/oneway/{id_from}/{id_to}/{fecha_saldida}")
	public List<?> oneWay(int id_from, int id_to, String fecha_salida){
		List<?> oneway = rutasInterfacesServices.onWayTrip(id_from, id_to, fecha_salida);
		return oneway;
	}
	
	@GetMapping("/oneway/{id_from}/{id_to}/{fecha_llegada}")
	public List<?> roundTrip(int id_to, int id_from, String fecha_llegada){
		List<?> oneway = rutasInterfacesServices.onWayTrip(id_from, id_to, fecha_llegada);
		return oneway;
	}
}
