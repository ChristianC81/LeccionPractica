/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tendenciasm5b.proyectousuarios.repository;


import com.tendenciasm5b.proyectousuarios.model.ControlEgIn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author chris
 */
public interface ControlEgInRepository extends JpaRepository<ControlEgIn, Integer>{
        @Query(value = "Select * from controlegin u where u.id_control = :id_control", nativeQuery = true)
    public ControlEgIn buscarControlEgIn(int id_control);
}
