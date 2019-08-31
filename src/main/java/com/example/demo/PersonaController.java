/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost", maxAge = 3600)
@RestController
public class PersonaController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

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
    public List<Persona> personas() {
        
        List<Persona> personas = new ArrayList<>();
        
        personas.add(new Persona (1,"Miguel"));
        personas.add(new Persona (1,"Miguel"));
        personas.add(new Persona (1,"Miguel"));
        personas.add(new Persona (1,"Miguel"));
        return personas;
    }

    
    
    @PostMapping("/persona")
    Persona newPersona(@RequestBody Persona newPersona) {
        
        
        return new Persona(counter.incrementAndGet(),
                String.format(template, newPersona.getContent()));
    }

}
