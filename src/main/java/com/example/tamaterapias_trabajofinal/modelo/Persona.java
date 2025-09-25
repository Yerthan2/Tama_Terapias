package com.example.tamaterapias_trabajofinal.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@MappedSuperclass

public abstract class Persona {

    @NotBlank
    protected String nombre;

    @NotBlank
    @Column(unique = true)
    protected String email;

    @NotBlank
    protected String contrasena;

    @NotBlank
    protected RolUsuario rolUsuario;


}
