package com.example.tamaterapias_trabajofinal.modelo;

import jakarta.persistence.*;
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
@Table(name = "cita")

public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cita")
    private int idCita;

    //Se utiliza Positive, para que el valor, sea mayor a 0
    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @NotNull
    @ManyToOne
    @JoinColumn(name="id_servicio", nullable = false)
    private Servicio servicio;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "administrador", nullable = false)
    private Administrador administrador;

    //Como es una fecha en futuro, lo que tiene que ver que la fecha es para un futuro, no en el pasado
    @FutureOrPresent
    private LocalDateTime fecha;

    @NotNull
    @Enumerated(EnumType.STRING)
    private EstadoPedido estadoPedido;

}
