package com.example.siontravel.Model.Services;

import com.example.siontravel.Model.Entity.Reservas;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Map;

public interface ReservasInterfacesServices {

    public List<Reservas> listar();
    public void guardar(Reservas areas);
    public Reservas buscarById(int id);
    public void eliminar(int id);
    Flux<Reservas> getAll();
    public List<Reservas> obtenerReservaDesdeDB(Reservas reservas);

}
