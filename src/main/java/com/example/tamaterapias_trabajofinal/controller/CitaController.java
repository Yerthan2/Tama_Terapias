package com.example.tamaterapias_trabajofinal.controller;

import com.example.tamaterapias_trabajofinal.DTO.CitaResponseDTO;
import com.example.tamaterapias_trabajofinal.modelo.Cita;
import com.example.tamaterapias_trabajofinal.modelo.EstadoCita;
import com.example.tamaterapias_trabajofinal.service.CitaService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/citas")
@CrossOrigin(origins = "*")
public class CitaController {

    @Autowired
    private CitaService citaService;

    /**
     * Sirve para crear una cita y devuelvo una CitaDTO, que es sin algunos parámetros
     * @param cita
     * @return
     */
    @PostMapping
    public ResponseEntity<CitaResponseDTO> crearCita(@RequestBody Cita cita){

        CitaResponseDTO citaNuevaDTO = citaService.crearCita(cita);
        return ResponseEntity.status(HttpStatus.CREATED).body(citaNuevaDTO);

    }

    /**
     * Devuelve todas las citas (cita dto) que haya en la bbdd
     * @return
     */
    @GetMapping
    public ResponseEntity<Set<CitaResponseDTO>> listarCitas(){
        return ResponseEntity.ok(citaService.listarCitas());
    }


    /**
     * Sirve para buscar una cita según un id
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<CitaResponseDTO> buscarCita(@PathVariable Integer id){

        CitaResponseDTO citaNuevaDTO = citaService.bucarCitaID(id);
        return ResponseEntity.ok(citaNuevaDTO);

    }

    /**
     * Muestra las citas del usuario
     * @param idUsuario
     * @return
     */

    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<Set<CitaResponseDTO>> citasUsuario(@PathVariable Integer idUsuario){
       return ResponseEntity.ok(citaService.citasUsuario(idUsuario));
    }

    /**
     * Borra una cita por un id
     * @param id
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarCita(@PathVariable Integer id){


        boolean eliminar = citaService.eliminarCita(id);
        if(eliminar){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("cita no encontrada");
        }
    }


    /**
     * Filtra las citas por su estado, sirve como un historial
     */
    @GetMapping("/estado/{estado}")
    public ResponseEntity<Set<CitaResponseDTO>> buscarCitaEstado(@PathVariable("estado") EstadoCita estadoCita){
        return ResponseEntity.ok(citaService.buscarCitaEstado(estadoCita));
    }

    /**
     * Busca citas entre las fechas que se nos pase
     */

    @GetMapping("/fechas")
    public ResponseEntity<Set<CitaResponseDTO>> buscarCitaEntreFechas(@RequestParam("inicio") LocalDateTime fechaInicio,
                                                      @RequestParam("fin") LocalDateTime fechaFin){
       return ResponseEntity.ok(citaService.citasRangoFecha(fechaInicio, fechaFin));
    }


}
