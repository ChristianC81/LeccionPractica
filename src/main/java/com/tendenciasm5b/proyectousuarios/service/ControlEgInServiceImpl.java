/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tendenciasm5b.proyectousuarios.service;

import com.tendenciasm5b.proyectousuarios.model.ControlEgIn;
import com.tendenciasm5b.proyectousuarios.repository.ControlEgInRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author chris
 */
@Service
public class ControlEgInServiceImpl extends GenericServiceImpl<ControlEgIn, Integer> implements GenericService<ControlEgIn, Integer> {

    @Autowired
    ControlEgInRepository controlEgInRepository;

    @Override
    public CrudRepository<ControlEgIn, Integer> getDao() {
        return controlEgInRepository;
    }


}

