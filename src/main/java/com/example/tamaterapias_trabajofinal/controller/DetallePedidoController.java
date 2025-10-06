package com.example.tamaterapias_trabajofinal.controller;

import com.example.tamaterapias_trabajofinal.DTO.DetallePedidoDTO;
import com.example.tamaterapias_trabajofinal.modelo.DetallePedido;
import com.example.tamaterapias_trabajofinal.modelo.Pedido;
import com.example.tamaterapias_trabajofinal.service.DetallePedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/api/detalles")
@CrossOrigin(origins = "*")
public class DetallePedidoController {

    @Autowired
    DetallePedidoService detallePedidoService ;
    @Autowired
    private ResponseEntityExceptionHandler responseEntityExceptionHandler;


    @GetMapping
    public Set<DetallePedidoDTO> obtenerTodosDetallesPedido(){
        return new HashSet<>(detallePedidoService.listarDetallePedido());
    }

    @GetMapping("/{id}")
    public DetallePedidoDTO obtenerPorId(@PathVariable Integer id){
        return detallePedidoService.obtenerPorId(id);
    }
}
