package com.example.tamaterapias_trabajofinal.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Administrador {

    private int idAdministrador;
    private String nombre;
    private String email;
    private String contrasena;

}
