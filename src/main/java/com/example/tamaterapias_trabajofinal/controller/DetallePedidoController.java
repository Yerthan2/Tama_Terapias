package com.example.tamaterapias_trabajofinal.controller;

import com.example.tamaterapias_trabajofinal.DTO.DetallePedidoDTO;
import com.example.tamaterapias_trabajofinal.modelo.DetallePedido;
import com.example.tamaterapias_trabajofinal.modelo.Pedido;
import com.example.tamaterapias_trabajofinal.service.DetallePedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    /**
     * Lista a todos los detalles pedidos q haya en la bbdd
     * @return
     */
    @GetMapping
    public ResponseEntity<Set<DetallePedidoDTO>> obtenerDetallesPedido(){
        return ResponseEntity.ok(detallePedidoService.listarDetallePedido());
    }

    /**
     * Busca un detallePedido por su id, la cual pasamos por parámetr
     * Cod 200 si pudo hacerlo, si no 404
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<DetallePedidoDTO> obtenerPorId(@PathVariable Integer id){
        DetallePedidoDTO detallePedidoDTO = detallePedidoService.obtenerPorId(id);
        return ResponseEntity.ok(detallePedidoDTO);
    }

    /**
     * Devuelve un error 404 si no encuentra nada y si elimina, manda el cod 204
     * @param id
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarDetalle(@PathVariable Integer id){
        boolean eliminado = detallePedidoService.eliminarDetallePorId(id);
        if(eliminado){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Detalle pedido no encontrado");
    }

}
