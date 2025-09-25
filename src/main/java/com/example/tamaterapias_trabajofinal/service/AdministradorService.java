package com.example.tamaterapias_trabajofinal.service;

import com.example.tamaterapias_trabajofinal.modelo.Administrador;
import com.example.tamaterapias_trabajofinal.repository.AdministradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.stereotype.Service;

@Service
public class AdministradorService {

    @Autowired
    private AdministradorRepository administradorRepository;

    @Autowired


    //Crear Administrador

    public Administrador crearAdministrador(Administrador administrador){
        return administradorRepository.save(administrador);
    }

    //Elimina usuario a traves de un id
    public void eliminarUsuario(Integer id){

    }

    //Elimina a otro administrador a través de un id
    public void eliminarAdministrador(Integer id){
        administradorRepository.deleteById(id);
    }





}
