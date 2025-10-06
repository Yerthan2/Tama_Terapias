package com.example.tamaterapias_trabajofinal.DTO;

import com.example.tamaterapias_trabajofinal.DTO.usuario.UsuarioResponsetDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CitaResponseDTO {

    private Integer idCita;
    private LocalDateTime fecha;
    private String estado;
    private UsuarioResponsetDTO usuarioDTO;
    private ServicioResponseDTO servicioDTO;
    private AdministradorResponseDTO administradorDTO;



}
