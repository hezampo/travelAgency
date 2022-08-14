package com.example.siontravel.Model.Services;

import com.example.siontravel.Model.Entity.Rutas;
import com.example.siontravel.Model.Repository.RutasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RutasImplementServices implements RutasInterfacesServices{
	
	 @Autowired
	 private JdbcTemplate jdbcTemplate;
	 List<?> onwaytrip, roundtrip;

    @Autowired
    private RutasRepository rutasRepository;

    @Override
    public List<Rutas> listar() {
        return (List<Rutas>) rutasRepository.findAll();
    }

    @Override
    public void guardar(Rutas rutas) {
        rutasRepository.save(rutas);
    }

    @Override
    public Rutas buscarById(int id) {
        return (Rutas) rutasRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(int id) {
        rutasRepository.deleteById(id);
    }

    @Override
    public Rutas buscarRutaByAreas(int id) {
        return (Rutas) rutasRepository.findById(id).orElse(null);
    }
    
    @Override
    public List<?> onWayTrip(int id_from, int id_to, String fecha_salida){
        var sql = "SELECT DISTINCT r.id AS id_ruta, r.precio_adulto, r.precio_infante, r.precio_equipaje, a.nombre AS origen, a1.nombre AS destino, b.hora_salida, b.hora_llegada, b.id AS id_bus, b.bus, b.id_from, b1.id_to FROM rutas r LEFT JOIN area a ON (r.id_from = a.id) LEFT JOIN area a1 ON (r.id_to = a1.id) LEFT JOIN bus b ON (a.id = b.id_from) LEFT JOIN bus b1 ON (a1.id = b1.id_to) WHERE r.id_from = "+id_from+" AND r.id_to = "+id_to+" AND b.id_from = "+id_from+" AND b.id_to = "+id_to+" AND r.fecha_inicio <= '"+fecha_salida+"' AND r.fecha_final >= '"+fecha_salida+"' ";
        onwaytrip = this.jdbcTemplate.queryForList(sql);
		return onwaytrip;
    }
    
    @Override
    public List<?> roundTrip(int id_from, int id_to, String fecha_llegada){
        var sql = "SELECT DISTINCT r.id AS id_ruta, r.precio_adulto, r.precio_infante, r.precio_equipaje, a.nombre AS origen, a1.nombre AS destino, b.hora_salida, b.hora_llegada, b.id AS id_bus, b.bus, b.id_from, b1.id_to FROM rutas r LEFT JOIN area a ON (r.id_from = a.id) LEFT JOIN area a1 ON (r.id_to = a1.id) LEFT JOIN bus b ON (a.id = b.id_from) LEFT JOIN bus b1 ON (a1.id = b1.id_to) WHERE r.id_to = "+id_from+" AND r.id_from = "+id_to+" AND b.id_to = "+id_from+" AND b.id_from = "+id_to+" AND r.fecha_inicio <= '"+fecha_llegada+"' AND r.fecha_final >= '"+fecha_llegada+"' ";
        roundtrip = this.jdbcTemplate.queryForList(sql);
        return roundtrip;
    }


}
