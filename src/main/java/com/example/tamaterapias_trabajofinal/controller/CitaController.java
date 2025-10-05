package com.example.tamaterapias_trabajofinal.controller;

import com.example.tamaterapias_trabajofinal.modelo.Cita;
import com.example.tamaterapias_trabajofinal.modelo.EstadoCita;
import com.example.tamaterapias_trabajofinal.service.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/citas")
public class CitaController {

    @Autowired
    private CitaService citaService;

    /**
     * Sirve para crear una cita
     * @param cita
     * @return
     */
    @PostMapping
    public Cita crearCita(@RequestBody Cita cita){
        return citaService.crearCita(cita);
    }

    @GetMapping
    public Set<Cita> getCitas(){
        return citaService.listarCitas();
    }


    /**
     * Sirve para buscar una cita según un id
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Cita buscarCita(@PathVariable Integer id){
        return citaService.bucarCitaID(id);
    }

    /**
     * Muestra las citas del usuario
     * @param idUsuario
     * @return
     */

    @GetMapping("/usuario/{idUsuario}")
    public Set<Cita> citasUsuario(@PathVariable Integer idUsuario){
        return citaService.citasUsuario(idUsuario);
    }

    /**
     * Borra una cita por un id
     * @param id
     */
    @DeleteMapping("/{id}")
    public void eliminarCita(@PathVariable Integer id){
        citaService.eliminarCita(id);
    }


    /**
     * Busca citas según el estado que tengan, sirve para ver el historial de las cumplidas
     */
    @GetMapping("/estado/{estado}")
    public Set<Cita> buscarCitaEstado(EstadoCita estadoCita){
        return citaService.buscarCitaEstado(estadoCita);
    }

    /**
     * Busca citas entre las fechas que se nos pase
     */

    @GetMapping("/fechas")
    public Set<Cita> buscarCitaEntreFechas(LocalDateTime fechaInicio, LocalDateTime fechaFin){
        return citaService.citasRangoFecha(fechaInicio, fechaFin);
    }


}
