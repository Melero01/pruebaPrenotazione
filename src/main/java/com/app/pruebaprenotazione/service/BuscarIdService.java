package com.app.pruebaprenotazione.service;

import com.app.pruebaprenotazione.model.BuscarId;
import com.app.pruebaprenotazione.model.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Calendar;
import java.util.Date;
import java.util.ArrayList;

@Service
public class BuscarIdService {
    public Hotel Comparacion (BuscarId numero, List<Hotel> listaHoteles){
        Hotel resultado = new Hotel();
        for (Hotel x:listaHoteles){
            if (x.getId().equals(numero.getNumeroId())){
                resultado = x;
            }
            else {}
        }
    return resultado;
    }

}
