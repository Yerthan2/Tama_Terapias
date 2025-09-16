package com.example.tamaterapias_trabajofinal.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class DetallePedido {

    private int idDetalle;
    private int idPedido;
    private int idProducto;
    private int cantidad;
    private double subtotal;

}
