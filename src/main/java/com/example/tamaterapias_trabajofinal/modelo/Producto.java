package com.example.tamaterapias_trabajofinal.modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "producto")
public class Producto {

    @Id
    @Column(name = "id_producto")
    private Integer idProducto;

    @NotBlank
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
