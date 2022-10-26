package com.app.pruebaprenotazione.service;

import com.app.pruebaprenotazione.model.Habitacion;
import com.app.pruebaprenotazione.model.Tipo_Habitacion;
import com.app.pruebaprenotazione.repository.HabitacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class HabitacionService {

    @Autowired
    private HabitacionRepository habitacionRepository;

    public List<Habitacion> getAll(){
        return habitacionRepository.findAll();
    }

    public Habitacion getById(int id){
        return habitacionRepository.findById(id).orElse(null);
    }

    public List<Habitacion> obtencion(Integer num, List<Habitacion> listaHabitaciones){
        List<Habitacion> habitaciones = new ArrayList<>();
        for (Habitacion x: listaHabitaciones){
            if (x.getId_hotel().getId().equals(num)){
                habitaciones.add(x);
            }
            else {

            }
        }
        return habitaciones;
    }

    public List<Tipo_Habitacion> todasHabitaciones(){
        List<Tipo_Habitacion> habitacion = new ArrayList<>();
        habitacion.add(Tipo_Habitacion.SIMPLE);
        habitacion.add(Tipo_Habitacion.DOBLE);
        habitacion.add(Tipo_Habitacion.SUITE);
        habitacion.add(Tipo_Habitacion.IMPERATOR);
        return habitacion;
    }

    public void saveHabitacion(Habitacion habitacion){
        habitacionRepository.save(habitacion);
    }

    public void deleteHabitacion(Integer id){
        habitacionRepository.deleteAllById(Collections.singleton(id));
    }

    public void editHabitacion(Integer id, Habitacion habitacion){
        List<Habitacion> listaHabitaciones = habitacionRepository.getHabitacionPorId(id);
        for (Habitacion h:listaHabitaciones){
            h.setNumero_habitacion(habitacion.getNumero_habitacion());
            h.setTipo_habitacion(habitacion.getTipo_habitacion());
            h.setHabitacion_ocupada(habitacion.getHabitacion_ocupada());
            h.setUsuarios_permitidos(habitacion.getUsuarios_permitidos());

            habitacionRepository.save(h);
        }
    }
}
