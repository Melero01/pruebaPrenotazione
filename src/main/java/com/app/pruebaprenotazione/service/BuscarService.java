package com.app.pruebaprenotazione.service;

import com.app.pruebaprenotazione.model.Buscar;
import com.app.pruebaprenotazione.model.Hotel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BuscarService{
    public List<Hotel> BotonBuscar(Buscar buscar, List<Hotel> listaHoteles){
        String srtBuscar;
        List<Hotel> coincidan = new ArrayList<>();
        srtBuscar = buscar.getHotelBuscado().toLowerCase();
        for(Hotel hoteles : listaHoteles) {
            if ((hoteles.getCiudad().toLowerCase().contains(srtBuscar)) ||
                    (hoteles.getNombre().toLowerCase().contains(srtBuscar))) {
                coincidan.add(hoteles);
            }
        }
        return coincidan;
    }
}

