package com.example.tamaterapias_trabajofinal.modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "producto")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Integer idProducto;

    @NotBlank(message = "El nombre del producto no puede estar vacio")
    @Column(name = "nombre_producto")
    @Size(min = 1, max = 50, message = "El nombre del producto no puede ser vacío")
    private String nombreProducto;

    @NotBlank(message = "La descripción del producto no puede estar vacía")
    @Size(min = 1, max = 300, message = "La descripción no puede tener más de 300 caracteres")
    private String descripcion;

    @NotNull(message = "El precio del producto no puede ser nulo")
    @DecimalMin(value = "0.0", inclusive = false, message = "El precio del producto debe ser mayor que 0")
    private Double precio;

    @NotBlank(message = "La imagen debe de introducirse la url")
    private String imagen;

    //Relaciones
    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
    private List<DetallePedido> detalles;

}
