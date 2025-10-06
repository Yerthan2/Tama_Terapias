package com.example.tamaterapias_trabajofinal.controller;

import com.example.tamaterapias_trabajofinal.DTO.CitaResponseDTO;
import com.example.tamaterapias_trabajofinal.DTO.usuario.UsuarioRequestDTO;
import com.example.tamaterapias_trabajofinal.DTO.usuario.UsuarioResponsetDTO;
import com.example.tamaterapias_trabajofinal.repository.UsuarioRepository;
import com.example.tamaterapias_trabajofinal.service.CitaService;
import com.example.tamaterapias_trabajofinal.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private CitaService citaService;
    @Autowired
    private UsuarioRepository usuarioRepository;

    /**
     * Crea un un usuario
     * coge el primero lo creamos para en la segunda linea guardarlo en la bbdd
     * @param usuario
     * @return
     */
    @PostMapping
    public UsuarioResponsetDTO crearUsuario(@RequestBody UsuarioRequestDTO usuario){
        return usuarioService.crearUsuario(usuario);
    }

    /*@GetMapping("/{id}")
    public UsuarioResponsetDTO buscarUsuario(@PathVariable Integer id){
        Usuario u = usuarioService.buscarUsuarioID(id);
        return UsuarioMapper.toDTO(u);
    }*/

    @GetMapping
    public Set<UsuarioResponsetDTO> listarUsuarios(){
        return new HashSet<>(usuarioService.listarUsuarios());
    }


    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable Integer id){
        usuarioService.eliminarUsuario(id);
    }


    @GetMapping("/{id}/citas")
    public Set<CitaResponseDTO> citasUsuario(@PathVariable Integer id){
        return new HashSet<>(citaService.citasUsuario(id));
    }
}
