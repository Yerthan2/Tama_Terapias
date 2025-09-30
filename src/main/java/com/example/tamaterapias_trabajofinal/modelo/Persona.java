package com.example.tamaterapias_trabajofinal.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@MappedSuperclass

public abstract class Persona {

    @NotBlank
    protected String nombre;

    @NotBlank
    protected String apellido;

    @NotBlank
    @Column(unique = true)
    protected String email;

    @NotBlank
    protected String contrasena;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "rolUsuario")
    protected RolUsuario rolUsuario;


}
