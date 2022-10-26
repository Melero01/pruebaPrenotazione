package com.app.pruebaprenotazione.repository;

import com.app.pruebaprenotazione.model.Habitacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HabitacionRepository extends JpaRepository<Habitacion, Integer> {

    List<Habitacion> findAll();
    List<Habitacion> getHabitacionPorId(Integer id);
}
