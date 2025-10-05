package com.example.tamaterapias_trabajofinal.modelo;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuario")
public class Usuario extends Persona{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    @EqualsAndHashCode.Include
    private Integer idUsuario;

    @PastOrPresent
    @Column(name = "fecha_registro")
    private LocalDate fecha_registro;



    //Parte de las relaciones
    //Aquí tenemos que tener en cuenta, que el usuario puede tener muchos pedidos y muchas citas

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Set<Pedido> pedidos;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Set<Cita> citas;

}
