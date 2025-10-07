package com.example.tamaterapias_trabajofinal.controller;

import com.example.tamaterapias_trabajofinal.DTO.PedidoDTO;
import com.example.tamaterapias_trabajofinal.modelo.Pedido;
import com.example.tamaterapias_trabajofinal.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/pedidos")
@CrossOrigin(origins = "*")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    /**
     *Sirve para obtener todos los pedidos que tengamos
      * @return
     */
    @GetMapping
    public Set<PedidoDTO> listarPedidos(){
        return pedidoService.obtenerPedidos();
    }


    public PedidoDTO obtenerPedidoId(@PathVariable Integer id){
        return pedidoService.obtenerPedidoPorId(id);
    }

    public ResponseEntity<Pedido> crearPedido(@RequestBody Pedido p){
        Pedido pedido = pedidoService.crearPedido(p);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(pedido);
    }

    @DeleteMapping("/{id}")
    public void eliminarPedido(@PathVariable Integer id){
        pedidoService.eliminarPedido(id);
    }
}
