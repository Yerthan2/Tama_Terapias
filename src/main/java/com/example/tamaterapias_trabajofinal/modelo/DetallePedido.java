package com.example.tamaterapias_trabajofinal.modelo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
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
    @NotNull(message = "Debe indicar el pedido asociado")
    private Pedido pedido;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_producto", nullable = false)
    @NotNull(message = "Debe indicar el producto asociado")
    private Producto producto;

    @NotNull(message = "Debe indicar la cantidad")
    private Integer cantidad;

    @NotNull(message = "El subtotal no puede ser nulo")
    @DecimalMin(value = "0.0", inclusive = false, message = "El subtotal debe ser mayor que 0")
    @Column(precision = 10, scale = 2)
    private Double subtotal;


}
