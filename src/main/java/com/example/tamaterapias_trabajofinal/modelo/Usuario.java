package com.example.tamaterapias_trabajofinal.modelo;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Usuario {

    @NotBlank
    private int idUsuario;

    @NotBlank
    private String nombre;

    @NotBlank
    private String email;

    @NotBlank
    private String contasena;

    @NotBlank
    private LocalDate fecha_registro;

}
