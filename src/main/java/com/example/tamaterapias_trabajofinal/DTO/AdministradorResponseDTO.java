package com.example.tamaterapias_trabajofinal.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdministradorResponseDTO {

    private String nombre;
    private String apellido1;
    private String apellido2;
    private String email;
    private String rolUsuario;


}
