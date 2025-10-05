package com.example.tamaterapias_trabajofinal.modelo;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "administrador")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Administrador extends Persona {


    @Id
    @Column(name = "id_administrador")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int idAdministrador;


    //Relaciones
    //Un administrador, debería de tener citas, porque por eso trabaja
    @JsonManagedReference("admin-cita")
    @OneToMany(mappedBy = "administrador", cascade = CascadeType.ALL)
    private Set<Cita> citas;


}

