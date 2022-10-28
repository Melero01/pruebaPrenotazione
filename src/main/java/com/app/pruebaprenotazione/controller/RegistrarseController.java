package com.app.pruebaprenotazione.controller;

import com.app.pruebaprenotazione.model.Hotel;
import com.app.pruebaprenotazione.model.Usuario;
import com.app.pruebaprenotazione.service.HotelService;
import com.app.pruebaprenotazione.service.LoginService;
import com.app.pruebaprenotazione.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/login")
public class RegistrarseController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private LoginService loginService;

    @Autowired
    private HotelService hotelService;


    @PostMapping("/guardar")
    public String guardarCliente(@RequestBody Usuario usuario){
        usuarioService.guardarUsuario(usuario);
        loginService.savelogin(usuario.getEmail());
        return "Datos guardados correctamente";
    }

    @PostMapping("/guardarhotel")
    public String guardarHotel(@RequestBody Hotel hotel){
        hotelService.saveHotel(hotel);
        loginService.savelogin(hotel.getEmail());
        return "Datos guardados correctamente";
    }
}
