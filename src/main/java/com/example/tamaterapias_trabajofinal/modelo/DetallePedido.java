package com.example.tamaterapias_trabajofinal.modelo;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class DetallePedido {

    @NotBlank
    private int idDetalle;

    @NotBlank
    private int idPedido;

    @NotBlank
    private int idProducto;

    @NotBlank
    private int cantidad;

    @NotBlank
    private double subtotal;

}
