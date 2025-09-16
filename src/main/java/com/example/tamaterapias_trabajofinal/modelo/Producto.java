package com.example.tamaterapias_trabajofinal.modelo;

import jakarta.validation.constraints.NotBlank;

public class Producto {

    @NotBlank
    private int idProducto;

    @NotBlank
    private String nombreProducto;

    @NotBlank
    private String descripcion;

    @NotBlank
    private double precio;

    @NotBlank
    private String imagen;

}
