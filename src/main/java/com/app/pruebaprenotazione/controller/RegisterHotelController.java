package com.app.pruebaprenotazione.controller;

import com.app.pruebaprenotazione.model.Hotel;
import com.app.pruebaprenotazione.model.HotelRegist;
import com.app.pruebaprenotazione.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;


    @Controller
    public class RegisterHotelController {

        @Autowired
        private HotelService hotelService;

        @GetMapping("/registrohotel")
        public String registerhotel(Model model, @ModelAttribute Hotel hotel) {

            Hotel hotel1 = hotel;
            model.addAttribute("hotel", hotel1);

            List<String> listpais = Arrays.asList("España", "Estados_Unidos", "Alemania");
            model.addAttribute("listpais", listpais);

            List<String> listlocalidad = Arrays.asList("Sevilla", "Wisconsin", "Murcia");
            model.addAttribute("listlocalidad", listlocalidad);

            List<String> listtiphotel = Arrays.asList("HOSTAL", "HOTEL");
            model.addAttribute("listtiphotel", listtiphotel);

            return "registrohotel";
        }


        @PostMapping("/registrarhotel")
        public String registerhotelForm(@ModelAttribute("hotel") HotelRegist hotel) {
            if (hotel.getNombre() != null && hotel.getDireccion() != null && hotel.getPais() != null
                    && hotel.getCiudad() != null && hotel.getFecha_abre() != null
                    && hotel.getFecha_cierre() != null && hotel.getTipo_hotel() != null
                    && LocalDate.parse(hotel.getFecha_cierre()).isAfter(LocalDate.parse(hotel.getFecha_abre()))
                    && hotel.getEmail() != null && hotel.getEmail().getContrasenya() != null) {

                hotelService.saveHotel(hotelService.covertToHotel(hotel));
                System.out.println(hotelService.covertToHotel(hotel));

                return "redirect:/main";
            } else {

                return "redirect:/registrohotel";
            }

        }
}
