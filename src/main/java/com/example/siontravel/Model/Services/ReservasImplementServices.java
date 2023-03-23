package com.example.siontravel.Model.Services;

import ch.qos.logback.classic.Logger;
import com.example.siontravel.Model.Entity.Reservas;
import com.example.siontravel.Model.Repository.ReservasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;


import java.util.List;


@Service
public class ReservasImplementServices implements ReservasInterfacesServices{

    @Autowired
    private ReservasRepository reservasRepository;
    private Logger log;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    List<?> ultimaReserva;

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

    @Override
    public Flux<Reservas> getAll() {
        return (Flux<Reservas>) reservasRepository.findAll();
    }

    @Override
    public List<Reservas> obtenerReservaDesdeDB(Reservas reservas) {
        var sql = "SELECT * FROM RESERVAS WHERE NUMERO_RESERVA = '" + reservas.getNumero_reserva() + "'";
        ultimaReserva = this.jdbcTemplate.queryForList(sql);
        return (List<Reservas>)ultimaReserva;
    }
}
