package com.example.tamaterapias_trabajofinal.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Producto {

    @Id
    private Integer idProducto;

    @NotBlank
    private String nombreProducto;

    @NotBlank
    private String descripcion;

    @NotNull
    private double precio;

    @NotBlank
    private String imagen;

}
