package com.example.tamaterapias_trabajofinal.modelo;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Pedido {

    @NotBlank
    private int idPedido;

    @NotBlank
    private int idUsuario;

    @NotBlank
    private LocalDateTime fechaPedido;

    @NotBlank
    private double total;

    @NotBlank
    private EstadoPedido estadoPedido;

}
