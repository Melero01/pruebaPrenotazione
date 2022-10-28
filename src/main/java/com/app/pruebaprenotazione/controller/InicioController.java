package com.app.pruebaprenotazione.controller;

import com.app.pruebaprenotazione.model.Buscar;
import com.app.pruebaprenotazione.model.Hotel;
import com.app.pruebaprenotazione.service.BuscarService;
import com.app.pruebaprenotazione.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@Controller
public class InicioController {
    @Autowired
    private HotelService hotelService;

    @Autowired
    private BuscarService buscarService;

    @GetMapping("/main")
    public ModelAndView listaHotel(@ModelAttribute Buscar buscar) {
        List<Hotel> listaprimera = hotelService.getAll();
        Collections.shuffle(listaprimera);
        List<Hotel> listaHotel = listaprimera.subList(0, 3);
        ModelAndView model = new ModelAndView("main");
        model.addObject("listaHotel", listaHotel);
        model.addObject("fechamin", LocalDate.now());
        model.addObject("busqueda", buscar);
        return model;
    }

    @GetMapping("/hoteleditar")
    public ModelAndView registrarHotel() {
        ModelAndView model = new ModelAndView("registroHotel");
        return model;
    }


    @PostMapping("/main")
    public ModelAndView listaHoteles(@ModelAttribute Buscar buscar) {
        List<Hotel> listaHoteles = hotelService.getAll();
        ModelAndView model = new ModelAndView("resultado");
        List<Hotel> filtro = buscarService.BotonBuscar(buscar,listaHoteles);
        if(LocalDate.parse(buscar.getFechaEntrada()).isAfter(LocalDate.parse(buscar.getFechaSalida())))
        {
            return new ModelAndView("redirect:main");
        }
        model.addObject("fechamin", LocalDate.now());
        model.addObject("filtro", filtro);
        return model ;
    }

    @GetMapping("/")
    public String irAMain(@ModelAttribute Buscar buscar) {
        return "main";
    }
}
