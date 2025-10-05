package com.example.tamaterapias_trabajofinal.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@MappedSuperclass
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public abstract class Persona {

    @NotBlank
    protected String nombre;

    @NotBlank
    protected String apellido1;

    @NotBlank
    protected String apellido2;

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
