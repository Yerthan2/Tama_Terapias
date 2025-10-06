package com.example.tamaterapias_trabajofinal.mapper;

import com.example.tamaterapias_trabajofinal.DTO.AdministradorResponseDTO;
import com.example.tamaterapias_trabajofinal.DTO.CitaResponseDTO;
import com.example.tamaterapias_trabajofinal.DTO.ServicioResponseDTO;
import com.example.tamaterapias_trabajofinal.DTO.usuario.UsuarioResponsetDTO;
import com.example.tamaterapias_trabajofinal.modelo.Cita;

public class CitaMapper {

    public static CitaResponseDTO toDTO(Cita cita){
        CitaResponseDTO citaResponseDTO = new CitaResponseDTO();
        //PArte del usuario
        UsuarioResponsetDTO usuarioResponsetDTO = new UsuarioResponsetDTO();
        usuarioResponsetDTO.setNombre(cita.getUsuario().getNombre());
        usuarioResponsetDTO.setApellido1(cita.getUsuario().getApellido1());
        usuarioResponsetDTO.setApellido2(cita.getUsuario().getApellido2());
        usuarioResponsetDTO.setEmail(cita.getUsuario().getEmail());
        usuarioResponsetDTO.setFechaRegistro(cita.getUsuario().getFecha_registro());
        usuarioResponsetDTO.setIdUsuario(cita.getUsuario().getIdUsuario());
        usuarioResponsetDTO.setRolUsuario(cita.getUsuario().getRolUsuario().name());

        //Parte de Servicio

        ServicioResponseDTO servicioResponseDTO = new ServicioResponseDTO();
        servicioResponseDTO.setIdServicio(cita.getServicio().getIdServicio());
        servicioResponseDTO.setDescripcion(cita.getServicio().getDescripcion());
        servicioResponseDTO.setNombreServicio(cita.getServicio().getNombreServicio());
        servicioResponseDTO.setDuracion(cita.getServicio().getDuracion());
        servicioResponseDTO.setPrecio(cita.getServicio().getPrecio());

        // Parte del Administrador

        AdministradorResponseDTO administradorResponseDTO = new AdministradorResponseDTO();

        administradorResponseDTO.setNombre(cita.getAdministrador().getNombre());
        administradorResponseDTO.setApellido1(cita.getAdministrador().getApellido1());
        administradorResponseDTO.setApellido2(cita.getAdministrador().getApellido2());
        administradorResponseDTO.setEmail(cita.getAdministrador().getEmail());
        administradorResponseDTO.setRolUsuario(cita.getAdministrador().getRolUsuario().name());

        //Parde de la cita

        citaResponseDTO.setIdCita(cita.getIdCita());
        citaResponseDTO.setEstado(cita.getEstado().name());
        citaResponseDTO.setFecha(cita.getFecha());
        citaResponseDTO.setAdministradorDTO(administradorResponseDTO);
        citaResponseDTO.setServicioDTO(servicioResponseDTO);
        citaResponseDTO.setUsuarioDTO(usuarioResponsetDTO);

        return citaResponseDTO;

    }
}
