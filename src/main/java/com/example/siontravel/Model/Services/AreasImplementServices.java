package com.example.siontravel.Model.Services;

import com.example.siontravel.Model.Entity.Areas;
import com.example.siontravel.Model.Repository.AreasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreasImplementServices implements AreasInterfacesServices{

    @Autowired
    private AreasRepository areasRepository;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    List<?> rutaLista;

    @Override
    public List<Areas> listar() {
        return (List<Areas>) areasRepository.findAll();
    }

    @Override
    public void guardar(Areas areas) {
        areasRepository.save(areas);
    }

    @Override
    public Areas buscarById(int id) {
        return (Areas) areasRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(int id) {
        areasRepository.deleteById(id);
    }

    @Override
    public List<?> listaRutas(int id) {
        var sql = "SELECT DISTINCT r.id_to, a1.nombre FROM area a LEFT JOIN rutas r ON (a.id = r.id_from) LEFT JOIN area a1 ON (r.id_to = a1.id) WHERE r.id_from ="+id;
        rutaLista = this.jdbcTemplate.queryForList(sql);
        return rutaLista;
    }


}
