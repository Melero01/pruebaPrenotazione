package com.app.pruebaprenotazione.service;


import com.app.pruebaprenotazione.model.*;
import com.app.pruebaprenotazione.repository.HabitacionRepository;
import com.app.pruebaprenotazione.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    public List<Hotel> getAll(){
        return hotelRepository.findAll();
    }

    public Hotel getById(int id){
        return hotelRepository.findById(id).orElse(null);
    }

    public Hotel covertToHotel(HotelRegist hotel){

        hotel.getEmail().setTipo_usuario(Tipo_Cliente.EMPRESA);

        Hotel hotel1 = new Hotel();

        hotel1.setNombre(hotel.getNombre());
        hotel1.setPais(hotel.getPais());
        hotel1.setCiudad(hotel.getCiudad());
        hotel1.setDireccion(hotel.getDireccion());
        hotel1.setFecha_abre(LocalDate.parse(hotel.getFecha_abre()));
        hotel1.setFecha_cierre(LocalDate.parse(hotel.getFecha_cierre()));
        hotel1.setTelefono(hotel.getTelefono());
        hotel1.setTipo_hotel(hotel.getTipo_hotel());
        hotel1.setEmail(hotel.getEmail());

        return hotel1;
    }

    public void saveHotel(Hotel hotel){
        hotelRepository.save(hotel);
    }

    public List<Tipo_Servicio> todosServicios(){
        List<Tipo_Servicio> servicios = new ArrayList<>();
        servicios.add(Tipo_Servicio.COMPLETO);
        servicios.add(Tipo_Servicio.POR_HORAS);
        servicios.add(Tipo_Servicio.MEDIO_DIA);

        return servicios;
    }
}
