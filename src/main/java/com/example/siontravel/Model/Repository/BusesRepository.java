package com.example.siontravel.Model.Repository;

import com.example.siontravel.Model.Entity.Buses;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusesRepository extends CrudRepository<Buses, Integer> {

}
