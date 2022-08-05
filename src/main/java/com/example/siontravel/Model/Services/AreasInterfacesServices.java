package com.example.siontravel.Model.Services;

import com.example.siontravel.Model.Entity.Areas;

import java.util.List;

public interface AreasInterfacesServices {
    public List<Areas> listar();
    public void guardar(Areas areas);
    public Areas buscarById(int id);
    public void eliminar(int id);
    public List<?> listaRutas (int id);
}
