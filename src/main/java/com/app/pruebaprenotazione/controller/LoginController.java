package com.app.pruebaprenotazione.controller;
import com.app.pruebaprenotazione.model.Buscar;
import com.app.pruebaprenotazione.model.Login;
import com.app.pruebaprenotazione.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.List;

public class LoginController {
    @Autowired
    private LoginService loginService;


    @GetMapping("/login")
    public ModelAndView submitForm(@ModelAttribute Login login) {
        ModelAndView model = new ModelAndView("sesion");
        model.addObject("login", login);
        return model;

    }
    @PostMapping("/login")
    public String submitForm1(@ModelAttribute Login login, Buscar buscar) {

        ModelAndView model = new ModelAndView("sesion");
        model.addObject("login", login);
        ModelAndView model1 = new ModelAndView("main");
        model1.addObject("login", login);

        boolean cierto = loginService.Search(login);

        if(cierto){
            return "redirect:/main";
        }else {
            return "sesion";
        }
    }
}
