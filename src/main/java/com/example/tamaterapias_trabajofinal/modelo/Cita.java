package com.example.tamaterapias_trabajofinal.modelo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cita")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cita")
    private int idCita;

    //Se utiliza Positive, para que el valor, sea mayor a 0
    @NotNull(message = "Debe indicar el usuario de la cita")
    @ManyToOne
    @JsonBackReference("id_usuario")
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @NotNull(message = "Debe indicar el servicio asociado")
    @ManyToOne
    @JsonBackReference("servicio-cita")
    @JoinColumn(name="id_servicio", nullable = false)
    private Servicio servicio;

    @NotNull(message = "Debe indicar el administrador de la cita")
    @ManyToOne
    @JsonBackReference("admin-cita")
    @JoinColumn(name = "id_administrador", nullable = false)
    private Administrador administrador;

    //Como es una fecha en futuro, lo que tiene que ver que la fecha es para un futuro, no en el pasado
    @NotNull(message = "Debe indicar la fecha de la cita")
    @Future(message = "La cita debe programarse para una fecha futura")
    private LocalDateTime fecha;

    @NotNull(message = "Debe de indicar el estado de la cita")
    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private EstadoCita estado;

}
