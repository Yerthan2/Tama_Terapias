package com.example.tamaterapias_trabajofinal.modelo;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Servicio {

    @NotBlank
    private int idServicio;

    @NotBlank
    private String nombreServicio;


    private String descripcion;

    @NotBlank
    private int duracion;

    @NotBlank
    private double precio;

}
