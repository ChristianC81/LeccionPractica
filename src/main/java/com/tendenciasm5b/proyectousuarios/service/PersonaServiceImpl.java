/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tendenciasm5b.proyectousuarios.service;

import com.tendenciasm5b.proyectousuarios.model.Persona;
import com.tendenciasm5b.proyectousuarios.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author chris
 */
@Service
public class PersonaServiceImpl extends GenericServiceImpl<Persona, Integer> implements GenericService<Persona, Integer> {

    @Autowired
    PersonaRepository rolRepository;

    @Override
    public CrudRepository<Persona, Integer> getDao() {
        return rolRepository;
    }


}

