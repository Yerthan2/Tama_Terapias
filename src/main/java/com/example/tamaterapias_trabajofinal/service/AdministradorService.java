package com.example.tamaterapias_trabajofinal.service;

import com.example.tamaterapias_trabajofinal.DTO.usuario.UsuarioRequestDTO;
import com.example.tamaterapias_trabajofinal.DTO.usuario.UsuarioResponsetDTO;
import com.example.tamaterapias_trabajofinal.mapper.UsuarioMapper;
import com.example.tamaterapias_trabajofinal.modelo.Administrador;
import com.example.tamaterapias_trabajofinal.modelo.Usuario;
import com.example.tamaterapias_trabajofinal.repository.AdministradorRepository;
import com.example.tamaterapias_trabajofinal.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AdministradorService {

    @Autowired
    private AdministradorRepository administradorRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    //Crear Administrador

    public Administrador crearAdministrador(Administrador adm){
       return administradorRepository.save(adm);
    }


    //Elimina a otro administrador a través de un id
    public void eliminarAdministrador(Integer id){
        administradorRepository.deleteById(id);
    }

    //Busca a todos los administradores
    public Set<Administrador> listarAdministradores(){
        return new HashSet<>(administradorRepository.findAll());
    }


    //Busca a otro usuario
    public Administrador buscarPorId(Integer id){
        return administradorRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Admin no encontrado con el id" + id));
    }

    //Editar al Admin

    public Administrador editarAdmin(Administrador adm){
        return administradorRepository.save(adm);
    }


    //Crea a un usuario

    public UsuarioResponsetDTO crearUsuario(UsuarioRequestDTO usuario){
        Usuario usuario1 = UsuarioMapper.toEntity(usuario);
        Usuario guarda = usuarioRepository.save(usuario1);
        return UsuarioMapper.toDTO(guarda);
    }


}
