package com.app.pruebaprenotazione.model;

import lombok.*;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDate;

@Entity
@Table(name = "reserva")
@Getter @Setter @EqualsAndHashCode @NoArgsConstructor @AllArgsConstructor
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "id")
    private Integer id;

    @JoinColumn(name = "id_hotel")
    @OneToOne
    private Hotel id_hotel;

    @JoinColumn(name = "id_usuario")
    @ManyToOne
    private Usuario id_usuario;

    @JoinColumn(name = "fecha_llegada")
    private LocalDate fecha_llegada;

    @JoinColumn(name = "fecha_salida")
    private LocalDate fecha_salida;

    @JoinColumn(name = "precio_final")
    private Double precio_final;

    @JoinColumn(name = "numero_clientes")
    private Integer numero_clientes;

}
