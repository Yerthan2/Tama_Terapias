package com.example.tamaterapias_trabajofinal.mapper;

import com.example.tamaterapias_trabajofinal.DTO.UsuarioDTO;
import com.example.tamaterapias_trabajofinal.modelo.Usuario;

public class UsuarioMapper {

    public static UsuarioDTO modeloDTO(Usuario usuario){
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setIdUsuario(usuario.getIdUsuario());
        usuarioDTO.setNombre(usuario.getNombre());
        usuarioDTO.setEmail(usuario.getEmail());
        usuarioDTO.setRolUsuario(usuario.getRolUsuario().name());
        usuarioDTO.setFechaRegistro(usuario.getFecha_registro());
        return usuarioDTO;
    }
}
