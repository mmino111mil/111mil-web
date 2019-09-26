/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.example.demo.dao.PersonaRepository;
import com.example.demo.model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost", maxAge = 3600)
@RestController
public class PersonaController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    PersonaRepository personaRepository;

    @GetMapping("/persona")
    public Persona persona(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Persona(counter.incrementAndGet(),
                String.format(template, name));
    }
    
    /**
     * ver ejemplo git
     * @return 
     * abel
     */
    @GetMapping("/personas")
    @Transactional
    public List<Persona> personas() {
        
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona ("Miguel"));
        personas.add(new Persona ("Santi"));
        personas.add(new Persona ("Abel"));
        personas.add(new Persona ("Lucas"));
        personaRepository.saveAll(personas);
        return personas;
    }

    
    
    @PostMapping("/persona")
    Persona newPersona(@RequestBody Persona newPersona) {
        return new Persona(counter.incrementAndGet(),
                String.format(template, newPersona.getNombre()));
    }




}
