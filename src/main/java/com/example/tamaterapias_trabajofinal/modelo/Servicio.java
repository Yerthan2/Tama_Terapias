package com.example.tamaterapias_trabajofinal.modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
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

    @NotBlank(message = "El nombre del servicio no puede estar vacio")
    @Size(min = 2, max = 100, message = "El nombre del servicio, no puede superar los 100 carácteres")
    @Column(name = "nombre_servicio")
    private String nombreServicio;

    @NotBlank(message = "La descripción del servicio no puede estar vacío")
    @Size(min = 2, max = 100, message = "La descripción del servicio no puede estar superar los 100 carácteres")
    private String descripcion;

    @NotNull(message = "La duración del servicio no puede estar vacío")
    private Integer duracion;

    @NotNull(message = "El precio del servicio no puede estar vacío")
    @DecimalMin(value = "0.0", inclusive = false, message = "El precio debe ser mayor que cero")
    private Double precio;


    //Relaciones

    @OneToMany(mappedBy = "servicio", cascade = CascadeType.ALL)
    private Set<Cita> citas;
}
