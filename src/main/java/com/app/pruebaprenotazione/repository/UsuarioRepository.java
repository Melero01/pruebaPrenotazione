package com.app.pruebaprenotazione.repository;

import com.app.pruebaprenotazione.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
    @Query(value = "select id, nombre, apellidos, dni, telefono, email, from usuario", nativeQuery = true)
    List<Usuario> obtenerUsuario();
}
