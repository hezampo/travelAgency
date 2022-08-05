package com.example.siontravel.Model.Services;

import com.example.siontravel.Model.Entity.Reservas;
import com.example.siontravel.Model.Repository.ReservasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservasImplementServices implements ReservasInterfacesServices{

    @Autowired
    private ReservasRepository reservasRepository;

    @Override
    public List<Reservas> listar() {
        return (List<Reservas>) reservasRepository.findAll();
    }

    @Override
    public void guardar(Reservas reservas) {
        reservasRepository.save(reservas);
    }

    @Override
    public Reservas buscarById(int id) {
        return (Reservas) reservasRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(int id) {
        reservasRepository.deleteById(id);
    }
}
