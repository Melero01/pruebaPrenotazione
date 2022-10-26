package com.app.pruebaprenotazione.repository;

import com.app.pruebaprenotazione.model.Precio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrecioRepository extends JpaRepository<Precio, Integer> {
    List<Precio> findAll();
}
