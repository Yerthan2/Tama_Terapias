package com.example.tamaterapias_trabajofinal.controller;

import com.example.tamaterapias_trabajofinal.modelo.Servicio;
import com.example.tamaterapias_trabajofinal.repository.AdministradorRepository;
import com.example.tamaterapias_trabajofinal.repository.ServicioRepository;
import com.example.tamaterapias_trabajofinal.service.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servicios")
public class ServicioController {

    @Autowired
    private ServicioService servicioService;

    @Autowired
    private AdministradorRepository administradorRepository;

    //Función para obtener todos los servicios
    @GetMapping
    public List<Servicio> getServicios(){
        return servicioService.listarTodosServicios();
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






}
