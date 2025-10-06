package com.example.tamaterapias_trabajofinal.controller;

import com.example.tamaterapias_trabajofinal.DTO.PedidoDTO;
import com.example.tamaterapias_trabajofinal.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/pedidos")
@CrossOrigin(origins = "*")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public Set<PedidoDTO> listarPedidos(){

    }

}
