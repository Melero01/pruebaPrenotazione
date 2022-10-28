package com.app.pruebaprenotazione.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class HotelRegist {

    private Integer id;

    private String nombre;

    private String pais;

    private String ciudad;

    private String direccion;


    private String telefono;


    private String fecha_abre;


    private String fecha_cierre;

    @JoinColumn(name = "email")
    @ManyToOne(cascade = CascadeType.ALL)
    private Login email;


    private Tipo_Hotel tipo_hotel;

}
