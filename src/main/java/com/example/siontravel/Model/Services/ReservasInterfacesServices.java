package com.example.siontravel.Model.Services;

import com.example.siontravel.Model.Entity.Reservas;

import java.util.List;

public interface ReservasInterfacesServices {

    public List<Reservas> listar();
    public void guardar(Reservas areas);
    public Reservas buscarById(int id);
    public void eliminar(int id);
}
