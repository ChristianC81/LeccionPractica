/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tendenciasm5b.proyectousuarios.controller;

import com.tendenciasm5b.proyectousuarios.model.Venta;
import com.tendenciasm5b.proyectousuarios.service.VentaServiceImpl;
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
@RequestMapping("/venta")
public class VentaController {

    @Autowired
    VentaServiceImpl ventaService;

    @Operation(summary = "Se obtiene la lista de Ventas")
    @GetMapping("/listar")
    public ResponseEntity<List<Venta>> listaVentas() {
        return new ResponseEntity<>(ventaService.findByAll(), HttpStatus.OK);
    }

    @Operation(summary = "Debe enviar los campos del Venta")
    @PostMapping("/crear")
    public ResponseEntity<Venta> crearVenta(@RequestBody Venta u) {
        return new ResponseEntity<>(ventaService.save(u), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Venta> actualizarVenta(@PathVariable Integer id, @RequestBody Venta u) {
        Venta venta = ventaService.findById(id);
        if (venta != null) {
            try {
                
                venta.setPersona(u.getPersona());
                venta.setProducto(u.getProducto());
                venta.setCantidad(u.getCantidad());       
                venta.setPrecio(u.getPrecio());       
                venta.setFechadeventa(u.getFechadeventa());       
                venta.setVenta(u.getVenta());
                
                return new ResponseEntity<>(ventaService.save(venta), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } 
    }

    public ResponseEntity<Venta> elimiarVenta(@PathVariable Integer id) {
        ventaService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
