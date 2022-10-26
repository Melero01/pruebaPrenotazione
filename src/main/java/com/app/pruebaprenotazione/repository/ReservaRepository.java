package com.app.pruebaprenotazione.repository;

import com.app.pruebaprenotazione.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservaRepository extends JpaRepository<Reserva,Integer> {
    List<Reserva> findAll();
}


