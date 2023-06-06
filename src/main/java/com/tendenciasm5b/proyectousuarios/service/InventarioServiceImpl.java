/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tendenciasm5b.proyectousuarios.service;

import com.tendenciasm5b.proyectousuarios.model.Inventario;
import com.tendenciasm5b.proyectousuarios.repository.InventarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author chris
 */
@Service
public class InventarioServiceImpl extends GenericServiceImpl<Inventario, Integer> implements GenericService<Inventario, Integer> {

    @Autowired
    InventarioRepository inventarioRepository;

    @Override
    public CrudRepository<Inventario, Integer> getDao() {
        return inventarioRepository;
    }


}

