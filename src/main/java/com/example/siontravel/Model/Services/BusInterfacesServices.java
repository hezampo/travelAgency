package com.example.siontravel.Model.Services;

import com.example.siontravel.Model.Entity.Buses;

import java.util.List;

public interface BusInterfacesServices {
    public List<Buses> listar();
    public void guardar(Buses bus);
    public Buses buscarById(int id);
    public void eliminar(int id);
}
