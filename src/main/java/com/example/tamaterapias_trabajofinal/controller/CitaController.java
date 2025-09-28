package com.example.tamaterapias_trabajofinal.controller;

import com.example.tamaterapias_trabajofinal.modelo.Cita;
import com.example.tamaterapias_trabajofinal.service.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/citas")
public class CitaController {

    @Autowired
    private CitaService citaService;

    @PostMapping
    public Cita crearCita(Cita cita){
        return citaService.crearCita(cita);
    }


    @GetMapping("/{id}")
    public Cita buscarCita(@PathVariable Integer id){
        return citaService.bucarCitaID(id);
    }

    @GetMapping("/usuario/{idUsuario}")
    public List<Cita> citasUsuario(@PathVariable Integer idUsuario){
        return citaService.citasUsuario(idUsuario);
    }

    @DeleteMapping("/{id}")
    public void eliminarCita(@PathVariable Integer id){
        citaService.eliminarCita(id);
    }


    /**
     * Busca citas según el estado que tengan, sirve para ver el historial de las cumplidas
     */
    @GetMapping
    public List<Cita> buscarCitaEstado(){
        return citaService.buscarCitaEstado()

    }
}
