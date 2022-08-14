package com.example.siontravel.Model.Services;

import com.example.siontravel.Model.Entity.Rutas;

import java.util.List;

public interface RutasInterfacesServices {
    public List<Rutas> listar();
    public void guardar(Rutas rutas);
    public Rutas buscarById(int id);
    public void eliminar(int id);
    public Rutas buscarRutaByAreas(int id);
	public List<?> onWayTrip(int id_from, int id_to, String fecha_salida);
	public List<?> roundTrip(int id_from, int id_to, String fecha_llegada);
}
