package com.app.pruebaprenotazione.service;

import com.app.pruebaprenotazione.model.Login;
import com.app.pruebaprenotazione.repository.LoginRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {
    @Autowired
    private LoginRepository loginRepository;

    public List<Login> getAll(){
        return loginRepository.findAll();
    }

    public Boolean Search(Login login){
        List<Login> todoslogins = getAll();
        boolean registrao = true;

        for (int i = 0; i<todoslogins.size(); i++){
            if (todoslogins.get(i).getEmail().equals(login.getEmail())&&
                    todoslogins.get(i).getContrasenya().equals(login.getContrasenya())){
                registrao=true;
                break;
            }else {
                registrao=false;
            }
        }
    return registrao;}

    public void savelogin (Login login){
        loginRepository.save(login);
    }
}
