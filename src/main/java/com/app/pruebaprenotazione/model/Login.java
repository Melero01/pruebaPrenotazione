package com.app.pruebaprenotazione.model;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "login")
@Getter @Setter @EqualsAndHashCode @NoArgsConstructor @AllArgsConstructor

public class Login {
    @Id
    @JoinColumn(name = "email")
    private String email;

    @JoinColumn(name = "contrasenya")
    private String contrasenya;

    @JoinColumn(name = "tipo_usuario")
    private Tipo_Cliente tipo_usuario;
}
