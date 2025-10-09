package com.example.tamaterapias_trabajofinal.controller;

import com.example.tamaterapias_trabajofinal.DTO.PedidoDTO;
import com.example.tamaterapias_trabajofinal.modelo.Pedido;
import com.example.tamaterapias_trabajofinal.service.PedidoService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/pedidos")
@CrossOrigin(origins = "*")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    /**
     * Sirve para obtener todos los pedidos que tengamos
     * Devuelve el código 200 si todo va bbien
     * @return
     */
    @GetMapping
    public ResponseEntity<Set<PedidoDTO>> listarPedidos(){

        Set<PedidoDTO> pedidos = pedidoService.obtenerPedidos();
        return ResponseEntity.ok(pedidos);
    }

    /**
     * Le pasamos un id y busca un pedido por su id
     * COD : 200 existe, si no, error 404 no existe
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<PedidoDTO> obtenerPedidoId(@PathVariable Integer id){

        PedidoDTO pedidoDTO = pedidoService.obtenerPedidoPorId(id);
        return ResponseEntity.ok(pedidoDTO);
    }

    /**
     * Crea un nuevo Pedido devuelve codigo 201 si todo fue ok y el pedido
     * @param p
     * @return
     */

    @PostMapping
    public ResponseEntity<Pedido> crearPedido(@RequestBody Pedido p){
        Pedido pedido = pedidoService.crearPedido(p);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(pedido);
    }

    /**
     * Pasamos un id para saber cual es el pedido que quiere borrar
     * Devuelve el cod 204 si se elimina y 404 si no se encuentra
     * @param id
     */
    @DeleteMapping("/{id}")
    public void eliminarPedido(@PathVariable Integer id){
        pedidoService.eliminarPedido(id);
    }
}
