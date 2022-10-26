package com.app.pruebaprenotazione.model;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "hotel")
@Getter @Setter @EqualsAndHashCode @NoArgsConstructor @AllArgsConstructor
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "id")
    private Integer id;

    @JoinColumn(name = "nombre")
    private String nombre;

    @JoinColumn(name = "pais")
    private String pais;

    @JoinColumn(name = "ciudad")
    private String ciudad;

    @JoinColumn(name = "direccion")
    private String direccion;

    @JoinColumn(name = "telefono")
    private String telefono;

    @JoinColumn(name = "fecha_abre")
    private LocalDate fecha_abre;

    @JoinColumn(name = "fecha_cierre")
    private LocalDate fecha_cierre;

    @JoinColumn(name = "email")
    @ManyToOne(cascade = CascadeType.ALL)
    private Login email;

    @JoinColumn(name = "tipo_hotel")
    private Tipo_Hotel tipo_hotel;
}
