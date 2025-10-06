package com.example.tamaterapias_trabajofinal.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDTO {

    private Integer idPedido;
    private String nombreUsuario;
    private LocalDateTime fechaPedido;
    private double total;
    private String estadoPedido;
    private int totalProductos;
    private Set<DetallePedidoDTO> detalles;
}
