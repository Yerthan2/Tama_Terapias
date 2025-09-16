package com.example.tamaterapias_trabajofinal.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Pedido {

    private int idPedido;
    private int idUsuario;
    private LocalDateTime fechaPedido;
    private double total;
    private EstadoPedido estadoPedido;

}
