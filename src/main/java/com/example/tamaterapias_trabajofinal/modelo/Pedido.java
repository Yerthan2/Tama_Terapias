package com.example.tamaterapias_trabajofinal.modelo;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jdk.jfr.Name;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.processing.Exclude;

import java.math.BigDecimal;
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

    @NotNull(message = "El usuario no puede estar vacio")
    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable=false)
    private Usuario usuario;

    @NotNull(message = "La fecha del pedido no puede estar vacio")
    private LocalDateTime fechaPedido;

    @NotNull(message = "El subtotal no puede ser nulo")
    @DecimalMin(value = "0.0", inclusive = false, message = "El subtotal debe ser mayor que 0")
    private Double subtotal;

    @Enumerated(EnumType.STRING)
    @NotNull
    private EstadoPedido estadoPedido;

    @NotBlank(message = "La dirección de entrega no puede estar vacía")
    @Size(max = 150, message = "La dirección no puede superar los 150 caracteres")
    @Column(name = "direccion_envio")
    private String direccionEnvio;

    @JsonManagedReference
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private Set<DetallePedido> detalles;


}
