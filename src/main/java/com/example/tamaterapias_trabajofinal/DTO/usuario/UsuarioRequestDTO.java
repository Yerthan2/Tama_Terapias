package com.example.tamaterapias_trabajofinal.DTO.usuario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioRequestDTO {

    private String nombre;
    private String apellido1;
    private String apellido2;
    private String email;
    private String contrasena;
    private String rolUsuario;
    private LocalDate fechaRegistro;

}
