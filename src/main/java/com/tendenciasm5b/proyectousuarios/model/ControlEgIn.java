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
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.sql.Date;
import java.util.List;
import lombok.Data;

/**
 *
 * @author chris
 */
@Data
@Entity
public class ControlEgIn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_control")
    private int id_control;

    @Column(name = "egresos")
    private double egresos;

    @Column(name = "descripciongasto")
    private double descripciongasto;

    @Column(name = "total_ingresos")
    private double total_ingresos;

    @Column(name = "ingresos_netos")
    private double ingresos_netos;
    
    @JsonIgnore
    @OneToMany(mappedBy = "venta")
    private List<Venta> listaVentas;
}
