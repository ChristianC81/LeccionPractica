/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tendenciasm5b.proyectousuarios.repository;


import com.tendenciasm5b.proyectousuarios.model.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author chris
 */
public interface InventarioRepository extends JpaRepository<Inventario, Integer>{
        @Query(value = "Select * from inventario u where u.nombre = :nombre", nativeQuery = true)
    public Inventario buscarInventario(String nombre);
}
