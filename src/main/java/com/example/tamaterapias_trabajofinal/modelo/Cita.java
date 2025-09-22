package com.example.tamaterapias_trabajofinal.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Entity
@AllArgsConstructor
@NoArgsConstructor


public class Cita {

    @Id
    private int idCita;

    //Se utiliza Positive, para que el valor, sea mayor a 0
    @NotNull
    @Positive
    private Integer idUsuario;

    @NotNull
    @Positive
    private Integer idServicio;

    @NotNull
    @Positive
    private Integer idAdministrador;

    //Como es una fecha en futuro, lo que tiene que ver que la fecha es para un futuro, no en el pasado
    @FutureOrPresent
    private LocalDateTime fecha;

    @NotNull
    @Enumerated(EnumType.STRING)
    private EstadoPedido estadoPedido;

}
