package com.example.tamaterapias_trabajofinal.DTO;

import com.example.tamaterapias_trabajofinal.modelo.Administrador;
import com.example.tamaterapias_trabajofinal.modelo.Servicio;
import com.example.tamaterapias_trabajofinal.modelo.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CitaResponseDTO {

    private Integer idCita;
    private LocalDateTime fecha;
    private String estado;
    private Usuario usuario;
    private Servicio servicio;
    private Administrador administrador;


}
