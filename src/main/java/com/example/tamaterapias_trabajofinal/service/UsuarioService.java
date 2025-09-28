package com.example.tamaterapias_trabajofinal.service;

import com.example.tamaterapias_trabajofinal.modelo.Cita;
import com.example.tamaterapias_trabajofinal.modelo.Usuario;
import com.example.tamaterapias_trabajofinal.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {


    @Autowired
    private UsuarioRepository usuarioRepository;


    /**
     * Función apra crear un usuario
     * @param usuario
     * @return
     */
    public Usuario crearUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
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
    public Usuario buscarUsuarioID(Integer id){
        return usuarioRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Usuario no encontrado con el id" + id));
    }

    /**
     * Devuelve todos los usuarios que haya
     * @return
     */
    public List<Usuario> listarUsuarios(){
        return usuarioRepository.findAll();
    }



}
