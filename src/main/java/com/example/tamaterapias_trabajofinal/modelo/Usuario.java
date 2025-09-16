package com.example.tamaterapias_trabajofinal.modelo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Usuario {

    private int idUsuario;
    private String nombre;
    private String email;
    private String contasena;
    private LocalDate fecha_registro;

}
