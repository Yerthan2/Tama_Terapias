package com.example.tamaterapias_trabajofinal.mapper;

import com.example.tamaterapias_trabajofinal.DTO.UsuarioRequestDTO;
import com.example.tamaterapias_trabajofinal.DTO.UsuarioResponsetDTO;
import com.example.tamaterapias_trabajofinal.modelo.RolUsuario;
import com.example.tamaterapias_trabajofinal.modelo.Usuario;

public class UsuarioMapper {


    /**
     * Sirve para convertir un usuario en un DTO de salida que es lo que va a ver el usuario
     * por eso mismo, no le ponemos la contrasena, porque es algo que no va a ver
     * @param usuario
     * @return
     */
    public static UsuarioResponsetDTO toDTO(Usuario usuario){
        UsuarioResponsetDTO usuarioResponsetDTO = new UsuarioResponsetDTO();
        usuarioResponsetDTO.setIdUsuario(usuario.getIdUsuario());
        usuarioResponsetDTO.setNombre(usuario.getNombre());
        usuarioResponsetDTO.setApellido1(usuario.getApellido1());
        usuarioResponsetDTO.setApellido2(usuario.getApellido2());
        usuarioResponsetDTO.setEmail(usuario.getEmail());
        usuarioResponsetDTO.setFechaRegistro(usuario.getFecha_registro());
        usuarioResponsetDTO.setRolUsuario((usuario.getRolUsuario().name()).toUpperCase());


        return usuarioResponsetDTO;
    }

    /**
     * Sirve para convertir lo que nos manda el cliente en una entidad usuario
     * @param usuarioRequestDTO
     * @return
     */

    public static Usuario toEntity(UsuarioRequestDTO usuarioRequestDTO){
        Usuario usuario = new Usuario();

        usuario.setNombre(usuarioRequestDTO.getNombre());
        usuario.setApellido1(usuarioRequestDTO.getApellido1());
        usuario.setApellido2(usuarioRequestDTO.getApellido2());
        usuario.setEmail(usuarioRequestDTO.getEmail());
        usuario.setContrasena(usuarioRequestDTO.getContrasena());
        usuario.setRolUsuario(RolUsuario.valueOf(usuarioRequestDTO.getRolUsuario().toUpperCase()));
        usuario.setFecha_registro(usuarioRequestDTO.getFechaRegistro());
        return usuario;
    }
}
