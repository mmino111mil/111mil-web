/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.dao;
import com.example.demo.model.Direccion;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author PC10
 */
public interface DireccionRepository  extends CrudRepository<Direccion, Long> {

    //List<Persona> findByLastName(String lastName);

    Direccion findById(long id);
}
    

