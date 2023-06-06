/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tendenciasm5b.proyectousuarios.service;

import com.tendenciasm5b.proyectousuarios.model.Venta;
import com.tendenciasm5b.proyectousuarios.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author chris
 */
@Service
public class VentaServiceImpl extends GenericServiceImpl<Venta, Integer> implements GenericService<Venta, Integer> {

    @Autowired
    VentaRepository ventaRepository;

    @Override
    public CrudRepository<Venta, Integer> getDao() {
        return ventaRepository;
    }


}

