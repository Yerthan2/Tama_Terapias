package com.example.tamaterapias_trabajofinal.modelo;

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
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "servicio")
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_servicio")
    @EqualsAndHashCode.Include
    private Integer idServicio;

    @NotBlank
    @Column(name = "nombre_servicio")
    private String nombreServicio;

    @NotBlank
    private String descripcion;

    @NotNull
    private Integer duracion;

    @NotNull
    private double precio;


    //Relaciones

    @OneToMany(mappedBy = "servicio", cascade = CascadeType.ALL)
    private Set<Cita> citas;
}
