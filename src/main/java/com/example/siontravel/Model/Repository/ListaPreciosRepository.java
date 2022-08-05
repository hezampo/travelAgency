package com.example.siontravel.Model.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.siontravel.Model.Entity.ListaPrecios;

@Repository
public interface ListaPreciosRepository extends CrudRepository<ListaPrecios, Integer>{

}
