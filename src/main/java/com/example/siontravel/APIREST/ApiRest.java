package com.example.siontravel.APIREST;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.siontravel.Model.Services.AreasInterfacesServices;

@RestController
@RequestMapping("/v1/apiRest")
public class ApiRest {
	
	@Autowired
    private AreasInterfacesServices areasInterfacesServices;
	
	@GetMapping("/load/{id}")
    public List<?> getRutaForIdArea(@PathVariable("id") int id){
        List<?> getRutaForIdArea = areasInterfacesServices.listaRutas(id);
        return getRutaForIdArea;
    }
}
