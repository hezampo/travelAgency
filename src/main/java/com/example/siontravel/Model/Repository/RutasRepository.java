package com.example.siontravel.Model.Repository;

import com.example.siontravel.Model.Entity.Rutas;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;




@Repository
public interface RutasRepository extends CrudRepository<Rutas, Integer> {
}
