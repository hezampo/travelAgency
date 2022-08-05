package com.example.siontravel.Model.Repository;

import com.example.siontravel.Model.Entity.Areas;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CiudadRepository extends CrudRepository<Areas, Integer> {

}
