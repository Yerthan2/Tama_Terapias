package com.example.tamaterapias_trabajofinal.modelo;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Cita {

    @NotBlank
    private int idCita;
    @NotBlank
    private int idUsuario;
    @NotBlank
    private int idServicio;
    @NotBlank
    private int idAdministrador;
    @NotBlank
    private LocalDateTime fecha;
    private EstadoPedido estadoPedido;

}
