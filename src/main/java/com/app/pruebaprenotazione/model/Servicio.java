package com.app.pruebaprenotazione.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

    @Entity
    @Table(name = "servicio")
    @Getter
    @Setter
    @EqualsAndHashCode
    @NoArgsConstructor
    @AllArgsConstructor

    public class Servicio {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @JoinColumn(name = "id")
        private Integer id;

        @JoinColumn(name = "id_hotel")
        @OneToOne
        private Hotel id_hotel;

        @JoinColumn(name = "tipo")
        private Tipo_Servicio tipo;

        @JoinColumn(name = "precio")
        private Double precio;

    }
