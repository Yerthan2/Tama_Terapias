package com.example.tamaterapias_trabajofinal.modelo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "detallePedido")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class DetallePedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_detalle")
    private Integer idDetalle;

    @NotNull
    @ManyToOne
    @JoinColumn(name="id_pedido", nullable = false)
    @JsonBackReference
    private Pedido pedido;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_producto", nullable = false)
    private Producto producto;

    @NotNull
    private Integer cantidad;

    @NotNull
    private double subtotal;

}
