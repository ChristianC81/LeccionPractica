/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tendenciasm5b.proyectousuarios.controller;

import com.tendenciasm5b.proyectousuarios.model.Persona;
import com.tendenciasm5b.proyectousuarios.service.PersonaServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author chris
 */
@RestController
@RequestMapping("/persona")
public class PersonaController {

    @Autowired
    PersonaServiceImpl personaService;

    @Operation(summary = "Se obtiene la lista de Personas")
    @GetMapping("/listar")
    public ResponseEntity<List<Persona>> listaPersonas() {
        return new ResponseEntity<>(personaService.findByAll(), HttpStatus.OK);
    }

    @Operation(summary = "Debe enviar los campos del Persona")
    @PostMapping("/crear")
    public ResponseEntity<Persona> crearPersona(@RequestBody Persona u) {
        return new ResponseEntity<>(personaService.save(u), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Persona> actualizarPersona(@PathVariable Integer id, @RequestBody Persona u) {
        Persona persona = personaService.findById(id);
        if (persona != null) {
            try {
                
                persona.setNombre(u.getNombre());
                persona.setApellido(u.getApellido());             
                persona.setCedula(u.getCedula());
                persona.setDireccion(u.getDireccion());
                persona.setCelular(u.getCelular());
                
                return new ResponseEntity<>(personaService.save(persona), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } 
    }

    public ResponseEntity<Persona> elimiarPersona(@PathVariable Integer id) {
        personaService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
