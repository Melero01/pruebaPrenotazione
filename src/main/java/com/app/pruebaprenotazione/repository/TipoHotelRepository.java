package com.app.pruebaprenotazione.repository;

import com.app.pruebaprenotazione.model.Tipo_Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TipoHotelRepository extends JpaRepository<Tipo_Hotel, Integer> {
    List<Tipo_Hotel> findAll();
}
