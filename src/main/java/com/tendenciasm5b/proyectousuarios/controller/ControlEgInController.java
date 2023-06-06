/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tendenciasm5b.proyectousuarios.controller;

import com.tendenciasm5b.proyectousuarios.model.ControlEgIn;
import com.tendenciasm5b.proyectousuarios.service.ControlEgInServiceImpl;
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
@RequestMapping("/controlEgIn")
public class ControlEgInController {

    @Autowired
    ControlEgInServiceImpl controlEgInService;

    @Operation(summary = "Se obtiene la lista de ControlEgIns")
    @GetMapping("/listar")
    public ResponseEntity<List<ControlEgIn>> listaControlEgIns() {
        return new ResponseEntity<>(controlEgInService.findByAll(), HttpStatus.OK);
    }

    @Operation(summary = "Debe enviar los campos del ControlEgIn")
    @PostMapping("/crear")
    public ResponseEntity<ControlEgIn> crearControlEgIn(@RequestBody ControlEgIn u) {
        return new ResponseEntity<>(controlEgInService.save(u), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<ControlEgIn> actualizarControlEgIn(@PathVariable Integer id, @RequestBody ControlEgIn u) {
        ControlEgIn controlEgIn = controlEgInService.findById(id);
        if (controlEgIn != null) {
            try {
                
                controlEgIn.setEgresos(u.getEgresos());
                controlEgIn.setDescripciongasto(u.getDescripciongasto());       
                
                
                return new ResponseEntity<>(controlEgInService.save(controlEgIn), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } 
    }

    public ResponseEntity<ControlEgIn> elimiarControlEgIn(@PathVariable Integer id) {
        controlEgInService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
