package com.app.pruebaprenotazione.service;


import com.app.pruebaprenotazione.model.Usuario;
import com.app.pruebaprenotazione.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.hibernate.query.criteria.internal.ValueHandlerFactory.isNumeric;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> getAll(){
        return usuarioRepository.findAll();
    }

    public Usuario getById(int id){
        return usuarioRepository.findById(id).orElse(null);
    }

    private final String dniCaracteres = "TRWAGMYFDPDXBNJZSQVHLCKE";
    public boolean DNIvalido(String DNI){
        String intDNI = DNI.trim().replaceAll("","").substring(0, 7);
        char letraDNI = DNI.charAt(8);
        int validarNumeroDNI = Integer.parseInt(intDNI) % 23;
        if (DNI.length()!= 9 && isNumeric(intDNI) == false && dniCaracteres.charAt(validarNumeroDNI) != letraDNI){
            return false;
        } else {
            return true;
        }
    }

    public void guardarUsuario(Usuario usuario){
        usuarioRepository.save(usuario);
    }
}
