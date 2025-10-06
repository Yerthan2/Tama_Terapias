package com.example.tamaterapias_trabajofinal.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServicioResponseDTO {

    private Integer idServicio;
    private String nombreServicio;
    private String descripcion;
    private Integer duracion;
    private Double precio;

}
