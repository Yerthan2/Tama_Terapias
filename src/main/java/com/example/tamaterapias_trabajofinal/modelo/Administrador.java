package com.example.tamaterapias_trabajofinal.modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "administrador")

public class Administrador extends Persona {


    @Id
    @Column(name = "id_administrador")
    private int idAdministrador;

    @NotBlank
    private RolUsuario rolUsuario;

    //Relaciones
    //Un administrador, debería de tener citas, porque por eso trabaja

    @OneToMany(mappedBy = "administrador", cascade = CascadeType.ALL)
    private List<Cita> citas;


}
