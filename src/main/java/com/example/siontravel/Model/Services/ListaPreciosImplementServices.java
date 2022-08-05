package com.example.siontravel.Model.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.siontravel.Model.Entity.ListaPrecios;
import com.example.siontravel.Model.Repository.ListaPreciosRepository;

@Service
public class ListaPreciosImplementServices implements ListaPreciosInterfacesServices{
	
	@Autowired
	private ListaPreciosRepository listaPreciosRepository;

	@Override
	public List<ListaPrecios> listar() {
		return (List<ListaPrecios>) listaPreciosRepository.findAll();
	}

	@Override
	public void guardar(ListaPrecios listaPrecios) {
		listaPreciosRepository.save(listaPrecios);
	}

	@Override
	public ListaPrecios buscarById(int id) {
		return (ListaPrecios) listaPreciosRepository.findById(id).orElse(null);
	}

	@Override
	public void eliminar(int id) {
		listaPreciosRepository.deleteById(id);
	}

	@Override
	public List<?> listaPrecios(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
