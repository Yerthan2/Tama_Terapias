package com.example.tamaterapias_trabajofinal.modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jdk.jfr.Name;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.processing.Exclude;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    private Integer idPedido;

    @NotNull
    private Integer idUsuario;

    @NotNull
    private LocalDateTime fechaPedido;

    @NotNull
    private double total;

    @Enumerated(EnumType.STRING)
    @NotNull
    private EstadoPedido estadoPedido;

}
