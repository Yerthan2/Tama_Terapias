package com.example.tamaterapias_trabajofinal.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.processing.Exclude;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Pedido {

    @Id
    private Integer idPedido;

    @NotNull
    private Integer idUsuario;

    @NotNull
    private LocalDateTime fechaPedido;

    @NotNull
    private double total;

    @NotBlank
    private EstadoPedido estadoPedido;

}
