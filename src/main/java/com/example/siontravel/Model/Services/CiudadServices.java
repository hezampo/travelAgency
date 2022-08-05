package com.example.siontravel.Model.Services;

import com.example.siontravel.Model.Entity.Areas;
import com.example.siontravel.Model.Repository.CiudadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CiudadServices implements CiudadInterfacesServices{

    @Autowired
    private CiudadRepository ciudadRepository;

    @Override
    public List<Areas> listaAreas() {
        return (List<Areas>) ciudadRepository.findAll();
    }
}
