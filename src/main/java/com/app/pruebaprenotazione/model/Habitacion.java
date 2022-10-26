package com.app.pruebaprenotazione.model;


import lombok.*;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
@Table(name = "habitacion")
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor

public class Habitacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "id")
    private Integer id;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "id_hotel")
    private Hotel id_hotel;

    @JoinColumn(name = "tipo_habitacion")
    private Tipo_Habitacion tipo_habitacion;

    @JoinColumn(name = "numero_habitacion")
    private Integer numero_habitacion;

    @JoinColumn(name = "habitacion_ocupada")
    private Integer habitacion_ocupada;

    @JoinColumn(name = "usuarios_permitidos")
    private Integer usuarios_permitidos;
}
