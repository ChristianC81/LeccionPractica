/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tendenciasm5b.proyectousuarios.controller;

import com.tendenciasm5b.proyectousuarios.model.Producto;
import com.tendenciasm5b.proyectousuarios.service.ProductoServiceImpl;
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
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    ProductoServiceImpl productoService;

    @Operation(summary = "Se obtiene la lista de Productos")
    @GetMapping("/listar")
    public ResponseEntity<List<Producto>> listaProductos() {
        return new ResponseEntity<>(productoService.findByAll(), HttpStatus.OK);
    }

    @Operation(summary = "Debe enviar los campos del Producto")
    @PostMapping("/crear")
    public ResponseEntity<Producto> crearProducto(@RequestBody Producto u) {
        return new ResponseEntity<>(productoService.save(u), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable Integer id, @RequestBody Producto u) {
        Producto producto = productoService.findById(id);
        if (producto != null) {
            try {
                
                producto.setNombre(u.getNombre());
                producto.setDescripcion(u.getDescripcion());       
                producto.setCategoria(u.getCategoria());       
                producto.setPrecio_emprendedor(u.getPrecio_emprendedor());       
                producto.setImagen(u.getImagen());
                producto.setTalla(u.getTalla());
                producto.setColores(u.getColores());       
                producto.setInventario(u.getInventario());
                
                return new ResponseEntity<>(productoService.save(producto), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } 
    }

    public ResponseEntity<Producto> elimiarProducto(@PathVariable Integer id) {
        productoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
