/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tendenciasm5b.proyectousuarios.controller;

import com.tendenciasm5b.proyectousuarios.model.Usuario;
import com.tendenciasm5b.proyectousuarios.service.UsuarioServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
@RequestMapping("/usuario")
public class UsuarioController {

    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    @Autowired
    UsuarioServiceImpl usuarioService;

    @Operation(summary = "Se obtiene la lista de Usuarios")
    @GetMapping("/listar")
    public ResponseEntity<List<Usuario>> listaUsuarios() {
        return new ResponseEntity<>(usuarioService.findByAll(), HttpStatus.OK);
    }

    @Operation(summary = "Debe enviar los campos del Usuario")
    @PostMapping("/crear")
    public ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario u) {
        return new ResponseEntity<>(usuarioService.save(u), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Usuario> actualizarUsuario(@PathVariable Integer id, @RequestBody Usuario u) {
        Usuario usuario = usuarioService.findById(id);
        if (usuario != null) {
            try {
                String hashedPassword = passwordEncoder.encode(u.getClave());
                usuario.setEmail(u.getEmail());
                usuario.setClave(hashedPassword);
                usuario.setPersona(u.getPersona());

                return new ResponseEntity<>(usuarioService.save(usuario), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Usuario> elimiarUsuario(@PathVariable Integer id) {
        usuarioService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
