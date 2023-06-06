/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tendenciasm5b.proyectousuarios.controller;

import com.tendenciasm5b.proyectousuarios.model.Inventario;
import com.tendenciasm5b.proyectousuarios.service.InventarioServiceImpl;
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
@RequestMapping("/inventario")
public class InventarioController {

    @Autowired
    InventarioServiceImpl inventarioService;

    @Operation(summary = "Se obtiene la lista de Inventarios")
    @GetMapping("/listar")
    public ResponseEntity<List<Inventario>> listaInventarios() {
        return new ResponseEntity<>(inventarioService.findByAll(), HttpStatus.OK);
    }

    @Operation(summary = "Debe enviar los campos del Inventario")
    @PostMapping("/crear")
    public ResponseEntity<Inventario> crearInventario(@RequestBody Inventario u) {
        return new ResponseEntity<>(inventarioService.save(u), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Inventario> actualizarInventario(@PathVariable Integer id, @RequestBody Inventario u) {
        Inventario inventario = inventarioService.findById(id);
        if (inventario != null) {
            try {

                inventario.setNombre(u.getNombre());
                inventario.setCantidad(u.getCantidad());

                return new ResponseEntity<>(inventarioService.save(inventario), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Inventario> elimiarInventario(@PathVariable Integer id) {
        inventarioService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
