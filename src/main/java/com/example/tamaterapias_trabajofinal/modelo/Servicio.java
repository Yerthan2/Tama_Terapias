package com.example.tamaterapias_trabajofinal.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "servicio")
public class Servicio {

    @Id
    private Integer idServicio;

    @NotBlank
    private String nombreServicio;

    @NotBlank
    private String descripcion;

    @NotNull
    private Integer duracion;

    @NotNull
    private double precio;

}
