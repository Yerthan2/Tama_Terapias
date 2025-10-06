package com.example.tamaterapias_trabajofinal.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetallePedidoDTO {
    private String nombreProducto;
    private String imagenProducto;
    private int cantidad;
    private double subtotal;

}
