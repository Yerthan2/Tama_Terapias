package com.example.tamaterapias_trabajofinal.modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "producto")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Integer idProducto;

    @NotBlank
    @Column(name = "nombre_producto")
    private String nombreProducto;

    @NotBlank
    private String descripcion;

    @NotNull
    private double precio;

    @NotBlank
    private String imagen;

    //Relaciones
    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
    private List<DetallePedido> detalles;

}
