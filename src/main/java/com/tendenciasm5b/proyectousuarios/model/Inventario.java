/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tendenciasm5b.proyectousuarios.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import java.util.List;
import lombok.Data;

/**
 *
 * @author chris
 */
@Data
@Entity
public class Inventario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_inventario")
    private int id_inventario;

     @NotBlank(message = "La nombre del inventario no puede estar en blanco")
    @Column(name = "nombre")
    private int nombre;
     
    @NotBlank(message = "La cantidad del inventario no puede estar en blanco")
    @Column(name = "cantidad")
    private int cantidad;
    
    @JsonIgnore
    @OneToMany(mappedBy = "inventario")
    private List<Producto> listaProductos;

}
