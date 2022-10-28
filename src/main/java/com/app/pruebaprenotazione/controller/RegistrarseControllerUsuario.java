package com.app.pruebaprenotazione.controller;

import com.app.pruebaprenotazione.model.Tipo_Cliente;
import com.app.pruebaprenotazione.model.Usuario;
import com.app.pruebaprenotazione.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.List;

@Controller
    public class RegistrarseControllerUsuario {

        @Autowired
        private UsuarioService usuarioService;


        @GetMapping("/register")
        public String registerForm(Model model, @ModelAttribute Usuario usuario) {

            Usuario cliente = usuario;

            model.addAttribute("usuario", cliente);

            List<String> listpais = Arrays.asList("España", "Francia", "Alemania");
            model.addAttribute("listpais", listpais);

            return "registrocliente";
        }

        @PostMapping("/registrocliente")
        public String registerForm(@ModelAttribute("cliente") Usuario usuario) {
            if(usuario.getNombre() != null && usuario.getApellidos() != null
                    && usuario.getEmail().getEmail() != null &&
                    usuario.getEmail().getContrasenya() != null && usuario.getDni() != null
                    && usuarioService.DNIvalido(usuario.getDni()) != false) {

                usuario.getEmail().setTipo_usuario(Tipo_Cliente.CLIENTE);
                usuarioService.guardarUsuario(usuario);
                System.out.println(usuario);

                return "redirect:/main";

            }else{


                return "redirect:/register";
            }
        }

    }
