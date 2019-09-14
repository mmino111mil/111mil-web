package com.example.demo.dao;

import com.example.demo.model.Persona;
import com.example.demo.model.Rol;
import org.springframework.data.repository.CrudRepository;

public interface RolRepository extends CrudRepository<Rol, Long> {

    Rol findById(long id);
}
