package com.example.tamaterapias_trabajofinal.controller;

import com.example.tamaterapias_trabajofinal.modelo.Servicio;
import com.example.tamaterapias_trabajofinal.repository.AdministradorRepository;
import com.example.tamaterapias_trabajofinal.repository.ServicioRepository;
import com.example.tamaterapias_trabajofinal.service.ServicioService;
import org.aspectj.lang.annotation.control.CodeGenerationHint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/servicios")
@CrossOrigin(origins = "*")
public class ServicioController {

    @Autowired
    private ServicioService servicioService;

    @Autowired
    private AdministradorRepository administradorRepository;

    /**
     * Sirve para obtener todos servicios que haya en la bbdd
     * @return
     */
    @GetMapping
    public ResponseEntity<Set<Servicio>> listarServicios(){
        return ResponseEntity.ok(servicioService.listarTodosServicios());
    }

    /**
     * Elimina el servicio, según el id que le pasamos
     * @param id
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarServicio(@PathVariable Integer id ){
        boolean servicioEliminado = servicioService.eliminarServicio(id);
        if(servicioEliminado){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Servicio no encontrado");
        }

    }

    /**
     *
     * @param id
     * @param servicioAct
     * @return
     */
    @PutMapping("/{id}")
    public Servicio actualizarServicio(@PathVariable Integer id, @RequestBody Servicio servicioAct){
        return servicioService.actualizarServicio(id, servicioAct);
    }

    /**
     * Crearemos el servicio, según nos
     * @param servicio
     * @return
     */
    @PostMapping
    public ResponseEntity<Servicio> crearServicio(@RequestBody Servicio servicio){
        Servicio servicioNuevo = servicioService.crearServicio(servicio);
        return ResponseEntity.status(HttpStatus.CREATED).body(servicioNuevo);
    }

    /**
     * Buscaremos un servicio, según el id que nos de el usuario
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<Servicio> buscarServicio(@PathVariable Integer id){
        return ResponseEntity.ok(servicioService.servicioPorId(id));
    }





}
