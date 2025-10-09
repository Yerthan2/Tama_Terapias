package com.example.tamaterapias_trabajofinal.service;

import com.example.tamaterapias_trabajofinal.DTO.usuario.UsuarioRequestDTO;
import com.example.tamaterapias_trabajofinal.DTO.usuario.UsuarioResponsetDTO;
import com.example.tamaterapias_trabajofinal.mapper.UsuarioMapper;
import com.example.tamaterapias_trabajofinal.modelo.Usuario;
import com.example.tamaterapias_trabajofinal.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
     * Función para eliminar el usuario, primero comprueba de que exista y luego elimina si existe
     * @param id
     * @return
     */

    public boolean eliminarUsuario(Integer id){
        if(usuarioRepository.existsById(id)){
            usuarioRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }


    /**
     * Función que busca a un usuario por su id, is no está, lo que hace es mandar una excepción
      * @param id
     * @return
     */
    public UsuarioResponsetDTO buscarUsuarioID(Integer id){
        Usuario u =  usuarioRepository.findById(id)
                .orElseThrow(()->new RuntimeException("El usuario que buscas no existe"));
        return UsuarioMapper.toDTO(u);
    }

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
