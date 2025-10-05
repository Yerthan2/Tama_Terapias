package com.example.tamaterapias_trabajofinal.controller;

import com.example.tamaterapias_trabajofinal.modelo.Servicio;
import com.example.tamaterapias_trabajofinal.repository.AdministradorRepository;
import com.example.tamaterapias_trabajofinal.repository.ServicioRepository;
import com.example.tamaterapias_trabajofinal.service.ServicioService;
import org.aspectj.lang.annotation.control.CodeGenerationHint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/servicios")
public class ServicioController {

    @Autowired
    private ServicioService servicioService;

    @Autowired
    private AdministradorRepository administradorRepository;

    //Función para obtener todos los servicios
    @GetMapping
    public Set<Servicio> getServicios(){
        return new HashSet<>(servicioService.listarTodosServicios());
    }

    //Eliminar Servicio
    @DeleteMapping("/{id}")
    public void eliminarServicio(@PathVariable Integer id ){
        servicioService.eliminarServicio(id);
    }

    @PutMapping("/{id}")
    public Servicio actualizarServicio(@PathVariable Integer id, @RequestBody Servicio servicioAct){
        return servicioService.actualizarServicio(id, servicioAct);
    }

    //Crea un servicio
    @PostMapping
    public Servicio crearServicio(@RequestBody Servicio servicio){
        return servicioService.crearServicio(servicio);
    }

    //Busca un servicio

    @GetMapping("/{id}")
    public Servicio buscarServicio(@PathVariable Integer id){
        return servicioService.servicioPorId(id);
    }





}
