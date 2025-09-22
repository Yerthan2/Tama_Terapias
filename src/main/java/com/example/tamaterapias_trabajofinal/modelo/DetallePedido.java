package com.example.tamaterapias_trabajofinal.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "detallePedido")
public class DetallePedido {

    @Id
    private Integer idDetalle;

    @NotNull
    private Integer idPedido;

    @NotNull
    private Integer idProducto;

    @NotNull
    private Integer cantidad;

    @NotNull
    private double subtotal;

}
