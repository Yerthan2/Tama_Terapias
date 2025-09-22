package com.example.tamaterapias_trabajofinal.modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "servicio")
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_servicio")
    private Integer idServicio;

    @NotBlank
    private String nombreServicio;

    @NotBlank
    private String descripcion;

    @NotNull
    private Integer duracion;

    @NotNull
    private double precio;


    //Relaciones

    @OneToMany(mappedBy = "servicio", cascade = CascadeType.ALL)
    private List<Cita> citas;
}
