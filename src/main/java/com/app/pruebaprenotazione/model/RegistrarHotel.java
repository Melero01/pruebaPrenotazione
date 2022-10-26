package com.app.pruebaprenotazione.model;

import lombok.*;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor

public class RegistrarHotel {

    public Tipo_Hotel Tipo_hotel;

    private Integer id;

    private String nombre;

    private String pais;

    private String ciudad;

    private String direccion;

    private String telefono;

    private LocalDate fecha_abre;

    private LocalDate fecha_cierre;

    @JoinColumn(name = "email")
    @ManyToOne(cascade = CascadeType.ALL)
    private Login email;
}
