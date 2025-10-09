package com.example.tamaterapias_trabajofinal.service;

import com.example.tamaterapias_trabajofinal.modelo.Servicio;
import com.example.tamaterapias_trabajofinal.repository.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ServicioService {

    @Autowired
    private ServicioRepository servicioRepository;

    //crear un servicio
    public Servicio crearServicio(Servicio servicio){
        return servicioRepository.save(servicio);
    }

    //Eliminar servicio a través de un id
    public void eliminarServicio(Integer id){
        servicioRepository.deleteById(id);
    }

    //Listar para todos los servicio
    public Servicio servicioPorId(Integer id){
        return servicioRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Servicio no encontrado"));
    }

    //Litar todos los servicios
    public Set<Servicio> listarTodosServicios(){
        return new HashSet<>(servicioRepository.findAll());
    }

    //Actualiza Servicio

    public Servicio actualizarServicio(Integer id, Servicio servicioActualizado) {
        Servicio servicio = servicioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Servicio no encontrado"));
        return servicioRepository.save(servicio);
    }

}
