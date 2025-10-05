package com.example.tamaterapias_trabajofinal.service;

import com.example.tamaterapias_trabajofinal.DTO.UsuarioRequestDTO;
import com.example.tamaterapias_trabajofinal.DTO.UsuarioResponsetDTO;
import com.example.tamaterapias_trabajofinal.mapper.UsuarioMapper;
import com.example.tamaterapias_trabajofinal.modelo.Cita;
import com.example.tamaterapias_trabajofinal.modelo.Usuario;
import com.example.tamaterapias_trabajofinal.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UsuarioService {


    @Autowired
    private UsuarioRepository usuarioRepository;


    /**
     * Función apra crear un usuario
     * coge el primero lo creamos para en la segunda linea guardarlo en la bbdd
     * @param usuario
     * @return
     */
    public UsuarioResponsetDTO crearUsuario(UsuarioRequestDTO usuario){

        Usuario usuario1 = UsuarioMapper.toEntity(usuario);
        Usuario guarda = usuarioRepository.save(usuario1);
        return UsuarioMapper.toDTO(guarda);
    }

    /**
     * Función para eliminar el usuario, si lo pide
     * @param id
     * @return
     */

    public void eliminarUsuario(Integer id){
        usuarioRepository.deleteById(id);
    }


    /**
     * Función que busca a un usuario por su id, is no está, lo que hace es mandar una excepción
      * @param id
     * @return
     */
 /*   public UsuarioRequestDTO buscarUsuarioID(Integer id){
        return usuarioRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Usuario no encontrado con el id" + id));
    }*/

    /**
     * Devuelve todos los usuarios que haya
     * @return
     */
    public Set<UsuarioResponsetDTO> listarUsuarios(){
        return usuarioRepository.findAll()
                .stream()
                .map(UsuarioMapper::toDTO)
                .collect(Collectors.toSet());
    }



}
