package com.example.siontravel.Model.Services;

import com.example.siontravel.Model.Entity.Buses;
import com.example.siontravel.Model.Repository.BusesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BusImplentServices implements BusInterfacesServices{

    @Autowired
    private BusesRepository busRepository;

    @Autowired
    JdbcTemplate jdbctemaplate = new JdbcTemplate();

    @Override
    public List<Buses> listar() {
        return (List<Buses>) busRepository.findAll();
    }

    @Override
    public void guardar(Buses bus) {
        busRepository.save(bus);
    }

    @Override
    public Buses buscarById(int id) {
        return (Buses) busRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(int id) {
        busRepository.deleteById(id);
    }

    @Override
    public void actualizarCapacidadBus(int totalPasajeros, int id_bus) {
        var sql = "update busoperator.bus set capacidad = "+totalPasajeros+" where id = "+id_bus+" ";
        jdbctemaplate.update(sql);
    }
}
