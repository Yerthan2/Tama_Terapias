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

    /**
     * Crea un nuevo servicio
     * @param servicio
     * @return
     */
    public Servicio crearServicio(Servicio servicio){
        return servicioRepository.save(servicio);
    }

    /**
     * Elimina el servicio con un id que se nos pase
     * @param id
     */
    public boolean eliminarServicio(Integer id){
        if(servicioRepository.existsById(id)){
            servicioRepository.deleteById(id);
            return true;
        }else {
            return false;
        }
    }

    /**
     * Busca un servicio con la id que le pasemos
     * @param id
     * @return
     */
    public Servicio servicioPorId(Integer id){
        return servicioRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Servicio no encontrado"));
    }

    /**
     * Lista todos los servicios que haya
     * @return
     */
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
