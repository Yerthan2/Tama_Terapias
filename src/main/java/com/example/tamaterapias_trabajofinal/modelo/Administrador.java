package com.example.tamaterapias_trabajofinal.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Administrador {


    @Id
    private int idAdministrador;

    @NotBlank
    private String nombre;

    @NotBlank
    private String email;

    @NotBlank
    private String contrasena;



}
