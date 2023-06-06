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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private int id_producto;

    @NotBlank(message = "El nombre de producto no puede estar en blanco")
    @Column(name = "nombre")
    private String nombre;

    @NotBlank(message = "La descripcion no puede estar en blanco")
    @Column(name = "descripcion")
    private String descripcion;

    @NotBlank(message = "La categoria del producto no puede estar en blanco")
    @Column(name = "categoria")
    private String categoria;

    @NotBlank(message = "El precio emprendedor del producto no puede estar en blanco")
    @Column(name = "precio_emprendedor")
    private double precio_emprendedor;

    @Column(name = "imagen")
    private String imagen;

    @NotBlank(message = "La talla del producto no puede estar en blanco")
    @Column(name = "talla")
    private String talla;

    @NotBlank(message = "Los colores del producto no puede estar en blanco")
    @Column(name = "colores")
    private String colores;

    @ManyToOne
    @JoinColumn(name = "id_inventario", referencedColumnName = "id_inventario")
    private Inventario inventario;

}
