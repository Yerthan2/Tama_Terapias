package com.example.tamaterapias_trabajofinal.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Servicio {

    private int idServicio;
    private String nombreServicio;
    private String descripcion;
    private int duracion;
    private double precio;


}
