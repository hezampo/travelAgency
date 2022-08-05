package com.example.siontravel.Model.Repository;

import com.example.siontravel.Model.Entity.Reservas;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservasRepository extends CrudRepository<Reservas, Integer> {
}
