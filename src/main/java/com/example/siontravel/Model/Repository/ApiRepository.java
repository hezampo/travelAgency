package com.example.siontravel.Model.Repository;

import com.example.siontravel.Model.Entity.Rutas;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ApiRepository extends CrudRepository<Rutas, Integer> {


    @Query(value = "SELECT nombre FROM area", nativeQuery = true)
    List<Rutas> findRutaByArea(int id);
}
