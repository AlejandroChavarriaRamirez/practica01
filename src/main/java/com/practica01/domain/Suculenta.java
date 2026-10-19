/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author aleja
 */

package com.practica01.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity //Mapea la tabla suculenta de la BD
@Table(name="suculenta")

public class Suculenta implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //El id lo asigna la BD automaticamente
    @Column(name="id_suculenta")
    private Integer idSuculenta;

    @Column(nullable=false, length=50)
    @NotBlank
    @Size(max=50)
    private String nombreComun;

    @Column(nullable=false, length=80)
    @NotBlank
    @Size(max=80)
    private String nombreCientifico;

    @Column(length=50)
    @Size(max=50)
    private String familia;

    @Column(length=30)
    @Size(max=30)
    private String colorPrincipal;

    @Column(precision=6, scale=2)
    private BigDecimal alturaCm;

    @Column(precision=12, scale=2)
    private BigDecimal precioEstimado;

    @Column(length=20)
    @Size(max=20)
    private String nivelRiego;

    @Column(length=1024)
    @Size(max=1024)
    private String rutaImagen;
}