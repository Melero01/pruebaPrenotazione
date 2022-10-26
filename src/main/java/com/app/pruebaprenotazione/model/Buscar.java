package com.app.pruebaprenotazione.model;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Buscar {
    private String hotelBuscado;
    private String fechaEntrada;
    private String fechaSalida;
}
