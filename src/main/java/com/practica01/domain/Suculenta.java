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
@Entity
@Table(name = "suculenta")
public class Suculenta implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_suculenta")
    private Integer idSuculenta;

    @NotBlank
    @Size(max = 50)
    @Column(nullable = false, length = 50)
    private String nombreComun;

    @NotBlank
    @Size(max = 80)
    @Column(nullable = false, length = 80)
    private String nombreCientifico;

    @Size(max = 50)
    @Column(length = 50)
    private String familia;

    @Size(max = 30)
    @Column(length = 30)
    private String colorPrincipal;

    @Column(precision = 6, scale = 2)
    private BigDecimal alturaCm;

    @Column(precision = 12, scale = 2)
    private BigDecimal precioEstimado;

    @Size(max = 20)
    @Column(length = 20)
    private String nivelRiego;

    // URL de la imagen en la nube
    @Size(max = 1024)
    @Column(length = 1024)
    private String rutaImagen;
}
