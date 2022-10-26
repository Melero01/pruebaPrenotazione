package com.app.pruebaprenotazione.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "precio")
@Getter @Setter @EqualsAndHashCode @NoArgsConstructor @AllArgsConstructor
public class Precio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_habitacion")
    private Habitacion id_habitacion;

    @ManyToOne
    @JoinColumn(name = "id_hotel")
    private Hotel id_hotel;

    @Column(name = "fecha_entrada")
    private LocalDate fecha_entrada;

    @Column(name = "fecha_salida")
    private LocalDate fecha_salida;

    @Column(name = "precio")
    private Double precio;



}
