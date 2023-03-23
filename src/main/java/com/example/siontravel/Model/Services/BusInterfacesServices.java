package com.example.siontravel.Model.Services;

import com.example.siontravel.Model.Entity.Buses;

import java.util.List;
import java.util.Map;

public interface BusInterfacesServices {
    public List<Buses> listar();
    public void guardar(Buses bus);
    public Buses buscarById(int id);
    public void eliminar(int id);
    public void actualizarCapacidadBus(int totalPasajeros, int id_bus);
}
