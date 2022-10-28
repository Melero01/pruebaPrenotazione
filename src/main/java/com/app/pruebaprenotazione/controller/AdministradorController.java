package com.app.pruebaprenotazione.controller;


import com.app.pruebaprenotazione.model.Habitacion;
import com.app.pruebaprenotazione.model.Tipo_Habitacion;
import com.app.pruebaprenotazione.service.BuscarService;
import com.app.pruebaprenotazione.service.HabitacionService;
import com.app.pruebaprenotazione.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AdministradorController {
    @Autowired
    private HotelService hotelService;

    @Autowired
    private BuscarService buscarService;

    @Autowired
    private HabitacionService habitacionService;

    @GetMapping("/admin")
    public ModelAndView admin() {
        List<Tipo_Habitacion> tipohab = habitacionService.todasHabitaciones();
        ModelAndView model = new ModelAndView("adminTest");
        model.addObject("tipohab",tipohab);
        model.addObject("habitaciones", new Habitacion());
        return model;
    }

    @RequestMapping(value = "/admin", method = RequestMethod.POST)
    public ModelAndView habitaciones(@ModelAttribute Habitacion habitacion) {
        habitacion.setHabitacion_ocupada(0);
        habitacionService.saveHabitacion(habitacion);
        ModelAndView model = new ModelAndView("adminHecho");
        return model;
    }

    @RequestMapping(value = "/admin/habitacion", method = RequestMethod.POST)
    public ModelAndView hotel(@RequestParam(value = "numero") Integer id) {
        List<Habitacion> listaHabitaciones = habitacionService.getAll();
        ModelAndView model = new ModelAndView("adminHabitacion");
        model.addObject("listaHabitacion", habitacionService.obtencion(id,listaHabitaciones));
        return model;
    }

    @RequestMapping("/admin/habitaciones/borrar/{numero}")
    public @ResponseBody ModelAndView borrarHabitacion(@PathVariable(value="numero") String numero,
                                                       @RequestParam(value = "id") Integer id) {
        habitacionService.deleteHabitacion(id);
        ModelAndView model = new ModelAndView("adminHecho");
        return model;
    }

    @RequestMapping("/admin/habitaciones/editar/{numero}")
    public @ResponseBody ModelAndView editarHabitacion(@PathVariable(value="numero") String numerito,
                                                       @RequestParam(value = "id") Integer id) {
        List<Habitacion> habitacion = new ArrayList<>();
        habitacion.add(habitacionService.getById(id));
        List<Tipo_Habitacion> tipohabitacion = habitacionService.todasHabitaciones();
        ModelAndView model = new ModelAndView("adminHabitacionEditar");
        model.addObject("tipohab", tipohabitacion);
        model.addObject("habitacion", habitacion);
        model.addObject("habitaciones", new Habitacion());
        return model;
    }

}
