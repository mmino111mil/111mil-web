/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.view;

import com.example.demo.dao.DireccionRepository;
import com.example.demo.dao.PersonaRepository;
import com.example.demo.model.Direccion;
import com.example.demo.model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ViewController {

    @Autowired
    PersonaRepository personaRepository;
    DireccionRepository direccionRepository;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/persona/alta")
    public String property(@ModelAttribute("persona") Persona persona, Model model) {
        personaRepository.save(persona);
        model.addAttribute("personas", personaRepository.findAll());
        return "persona/list";
    }

    @PostMapping("/Direccion/alta")
    public String property(@ModelAttribute("direccion") Direccion direccion, Model model) {
        direccionRepository.save(direccion);
        model.addAttribute("direcciones", direccionRepository.findAll());
        return "direccion/list";
    }

    @RequestMapping("/equipo")
    public String equipo(@ModelAttribute("persona") Persona persona, Model model) {
        return "equipo";
    }

    @RequestMapping("/persona/alta")
    public String personaAlta() {
        return "persona/alta";
    }

    @RequestMapping("/persona/list")
    public String personaList(Model model) {
        model.addAttribute("personas", personaRepository.findAll());
        return "persona/list";
    }
}
