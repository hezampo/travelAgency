package com.example.siontravel.Model.Services;

import java.util.List;

import com.example.siontravel.Model.Entity.ListaPrecios;

public interface ListaPreciosInterfacesServices {
	public List<ListaPrecios> listar();
    public void guardar(ListaPrecios listaPrecios);
    public ListaPrecios buscarById(int id);
    public void eliminar(int id);
    public List<?> listaPrecios (int id);
}
