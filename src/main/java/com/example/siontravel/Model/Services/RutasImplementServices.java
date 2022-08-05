package com.example.siontravel.Model.Services;

import com.example.siontravel.Model.Entity.Rutas;
import com.example.siontravel.Model.Repository.RutasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RutasImplementServices implements RutasInterfacesServices{

    @Autowired
    private RutasRepository rutasRepository;

    @Override
    public List<Rutas> listar() {
        return (List<Rutas>) rutasRepository.findAll();
    }

    @Override
    public void guardar(Rutas rutas) {
        rutasRepository.save(rutas);
    }

    @Override
    public Rutas buscarById(int id) {
        return (Rutas) rutasRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(int id) {
        rutasRepository.deleteById(id);
    }

    @Override
    public Rutas buscarRutaByAreas(int id) {
        return (Rutas) rutasRepository.findById(id).orElse(null);
    }


}
