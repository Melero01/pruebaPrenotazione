package com.app.pruebaprenotazione.model;


import lombok.*;

import javax.persistence.*;

@Entity
@Table (name = "usuario")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "id")
    private Integer id;

    @JoinColumn(name = "nombre")
    private String nombre;

    @JoinColumn(name = "apellidos")
    private String apellidos;

    @JoinColumn(name = "dni")
    private String dni;

    @JoinColumn(name = "telefono")
    private String telefono;

    @JoinColumn(name = "email")
    @ManyToOne(cascade = CascadeType.ALL)
    private Login email;

    public Usuario(String nombre, String apellidos, String dni, String telefono, Login email){
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.telefono = telefono;
        this.email = email;
    }
}
