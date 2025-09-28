package com.example.tamaterapias_trabajofinal.service;

import com.example.tamaterapias_trabajofinal.modelo.Cita;
import com.example.tamaterapias_trabajofinal.modelo.EstadoCita;
import com.example.tamaterapias_trabajofinal.repository.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CitaService {

    @Autowired
    private CitaRepository citaRepository;

    /**
     * Función para crear Cita
     * @param cita
     * @return
     */
    public Cita crearCita(Cita cita){
        return citaRepository.save(cita);
    }

    /**
     * Función para eliminar citar, le pasamos un id
     * @param id
     */
    public void eliminarCita(Integer id){
        citaRepository.deleteById(id);
    }


    /**
     * Función para buscar una cita según su id sino, manda mensaje
     * @param id
     * @return
     */
    public Cita bucarCitaID(Integer id){

        return citaRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Cita no encontrada id :" + id));

    }

    /**
     * Función que le pasaremos el idUSuario y nos pasará todas las citas que tenga
     * @param idUsuario
     * @return
     */
    public List<Cita> citasUsuario(Integer idUsuario){
       return citaRepository.buscarUsuarioId(idUsuario);
    }

    /**
     * Función para buscar las citas según su estado
     * Puede servir, para crear un historial de citas, ya finalizadas, buscar las que te quedan por hacer
     * @param estadoCita
     * @return
     */
    public List<Cita> buscarCitaEstado(EstadoCita estadoCita){
        return citaRepository.buscarCitaEstado(estadoCita);
    }

    public List<Cita> citasRangoFecha(LocalDateTime fechaIncio, LocalDateTime fechaFin){
        return citaRepository.buscarEntreFechas(fechaIncio, fechaFin);
    }



}
