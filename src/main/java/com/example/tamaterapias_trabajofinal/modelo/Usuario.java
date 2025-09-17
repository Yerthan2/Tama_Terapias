package com.example.tamaterapias_trabajofinal.modelo;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Usuario {

    @Id
    private Integer idUsuario;

    @NotBlank
    private String nombre;

    @NotBlank
    private String email;

    @NotBlank
    private String contasena;

    @PastOrPresent
    private LocalDate fecha_registro;

}
