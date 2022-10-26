package com.app.pruebaprenotazione.repository;

import com.app.pruebaprenotazione.model.Login;
import com.app.pruebaprenotazione.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface LoginRepository extends JpaRepository<Login, Integer> {
    @Query(value = "select email, contrasenya from login", nativeQuery = true)
    List<Usuario> obtenerUsuario();
}
