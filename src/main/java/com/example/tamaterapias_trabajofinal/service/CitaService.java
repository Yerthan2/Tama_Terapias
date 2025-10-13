package com.example.tamaterapias_trabajofinal.service;

import com.example.tamaterapias_trabajofinal.DTO.CitaResponseDTO;
import com.example.tamaterapias_trabajofinal.mapper.CitaMapper;
import com.example.tamaterapias_trabajofinal.modelo.Cita;
import com.example.tamaterapias_trabajofinal.modelo.EstadoCita;
import com.example.tamaterapias_trabajofinal.repository.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CitaService {

    @Autowired
    private CitaRepository citaRepository;

    /**
     * Función para crear Cita y devuelve CitaDto, para que no se muetren todos los datos
     * @param cita
     * @return
     */
    public CitaResponseDTO crearCita(Cita cita){

        Cita citaGuardada = citaRepository.save(cita);
        return CitaMapper.toDTO(citaGuardada);

    }

    /**
     * Función para eliminar citar, le pasamos un id
     * @param id
     */
    public boolean eliminarCita(Integer id){

        if(citaRepository.existsById(id)){
            citaRepository.deleteById(id);
            return true;
        }else{
            return false;
        }

    }

    /**
     * Litsa todas las citas que haya, pero devolvemos citaDto
     * @return
     */
    public Set<CitaResponseDTO> listarCitas(){

        return citaRepository.findAll().stream()
                .map(CitaMapper::toDTO)
                .collect(Collectors.toSet());
    }

    /**
     * Función para buscar una citadto según su id sino, manda mensaje
     * @param id
     * @return
     */
    public CitaResponseDTO bucarCitaID( Integer id){

        Cita cita = citaRepository.findById(id).orElseThrow(()-> new RuntimeException("no encontrada la cita"));
        return CitaMapper.toDTO(cita);

    }

    /**
     * Función que le pasaremos el idUSuario y nos pasará todas las citas que tenga
     * @param idUsuario
     * @return
     */
    public Set<CitaResponseDTO> citasUsuario( Integer idUsuario){

        return citaRepository.findByUsuario_IdUsuario(idUsuario)
                .stream().map(CitaMapper::toDTO)
                .collect(Collectors.toSet());

    }

    /**
     * Función para buscar las citas según su estado
     * Puede servir, para crear un historial de citas, ya finalizadas, buscar las que te quedan por hacer
     * @param estadoCita
     * @return
     */
    public Set<CitaResponseDTO> buscarCitaEstado(EstadoCita estadoCita){
        return citaRepository.findByEstado(estadoCita)
                .stream().map(CitaMapper::toDTO)
                .collect(Collectors.toSet());
    }

    /**
     * Sirve para hacder un filtro, para buscar entre fechas, mira las fechas que hay entre fechaInicio y fechaFin
     * Devuelve todas las citas que haya entre ese rango de fechas
     *
     * @param fechaIncio
     * @param fechaFin
     * @return
     */
    public Set<CitaResponseDTO> citasRangoFecha(LocalDateTime fechaIncio, LocalDateTime fechaFin){
        return citaRepository.findByFechaBetween(fechaIncio, fechaFin)
                .stream().map(CitaMapper::toDTO)
                .collect(Collectors.toSet());
    }



}
