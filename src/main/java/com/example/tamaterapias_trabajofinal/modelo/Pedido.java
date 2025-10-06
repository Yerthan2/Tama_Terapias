package com.example.tamaterapias_trabajofinal.modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jdk.jfr.Name;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.processing.Exclude;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pedido")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    private Integer idPedido;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable=false)
    private Usuario usuario;

    @NotNull
    private LocalDateTime fechaPedido;

    @NotNull
    private double total;

    @Enumerated(EnumType.STRING)
    @NotNull
    private EstadoPedido estadoPedido;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private Set<DetallePedido> detalles;

}
