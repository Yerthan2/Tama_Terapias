package com.example.tamaterapias_trabajofinal.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@MappedSuperclass
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public abstract class Persona {

    @NotBlank(message = "El nombre no puede estar en blanco")
    @Size(min = 2, max = 100, message = "El nombbre no puede tener más de 100 carácteres")
    protected String nombre;

    @NotBlank(message = "El apellido no puede estar vacio")
    @Size(min = 2, max = 100, message = "el apellido no puede menos de 2 carácteres ni más de 100")
    protected String apellido1;

    protected String apellido2;


    @NotBlank(message = "El correo electrónico no puede estar vacio")
    @Email(message = "Debe de ser un correo valido")
    @Column(unique = true)
    protected String email;

    @NotBlank(message = "La contraseña no puede estar vacía")
    protected String contrasena;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "rolUsuario")
    protected RolUsuario rolUsuario;


}
