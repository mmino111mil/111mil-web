/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

@CrossOrigin(origins = "http://localhost", maxAge = 3600)
@RestController
public class DBController {

    @Autowired
    private DataSource dataSource;


    @GetMapping("/db")
    public List<Persona> db() {
        List<Persona> personas = new ArrayList<>();

        try (Connection connection = dataSource.getConnection()) {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS ticks (tick timestamp)");
            stmt.executeUpdate("INSERT INTO ticks VALUES (now())");
            ResultSet rs = stmt.executeQuery("SELECT tick FROM ticks");
            int i = 0;
            while (rs.next()) {
                personas.add(new Persona(i++, "Read from DB: " + rs.getTimestamp("tick")));
            }

        } catch (Exception e) {

        }

        return personas;
    }


}
