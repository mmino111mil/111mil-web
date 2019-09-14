package com.example.demo.dao;

import com.example.demo.model.Persona;
import org.springframework.data.repository.CrudRepository;

public interface PersonaRepository extends CrudRepository<Persona, Long> {

    //List<Persona> findByLastName(String lastName);

    Persona findById(long id);
}
