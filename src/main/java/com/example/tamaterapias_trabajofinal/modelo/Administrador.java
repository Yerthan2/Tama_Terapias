package com.example.tamaterapias_trabajofinal.modelo;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Administrador {

    @NotBlank
    private int idAdministrador;

    @NotBlank
    private String nombre;

    @NotBlank
    private String email;

    @NotBlank
    private String contrasena;

}
