package com.example.tamaterapias_trabajofinal.controller;

import com.example.tamaterapias_trabajofinal.DTO.CitaResponseDTO;
import com.example.tamaterapias_trabajofinal.DTO.usuario.UsuarioRequestDTO;
import com.example.tamaterapias_trabajofinal.DTO.usuario.UsuarioResponsetDTO;
import com.example.tamaterapias_trabajofinal.modelo.Usuario;
import com.example.tamaterapias_trabajofinal.repository.UsuarioRepository;
import com.example.tamaterapias_trabajofinal.service.CitaService;
import com.example.tamaterapias_trabajofinal.service.UsuarioService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*")
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
     * Checkea el estado que nos debe de dar, nos debe de dar el 201 si todo ha ido correctamente
     * @param usuario
     * @return
     */
    @PostMapping
    public ResponseEntity<UsuarioResponsetDTO> crearUsuario(@RequestBody UsuarioRequestDTO usuario){
       UsuarioResponsetDTO usuarioResponsetDTO = usuarioService.crearUsuario(usuario);
       return ResponseEntity.status(HttpStatus.CREATED).body(usuarioResponsetDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponsetDTO> buscarUsuario(@PathVariable Integer id){
        UsuarioResponsetDTO u = usuarioService.buscarUsuarioID(id);
        return ResponseEntity.ok(u)   ;
    }

    @GetMapping
    public ResponseEntity<Set<UsuarioResponsetDTO>> listarUsuarios(){
       Set<UsuarioResponsetDTO> usuariosLista = usuarioService.listarUsuarios();
       return ResponseEntity.ok(usuariosLista);
    }

    /**
     * Sirve para eliminar el usuario, si no lo encontramos devuelve mensaje de error
     * El ? sirve como comodín nos puede llegar a devolver un UsuarioResponsetDTO o un String con un error
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarUsuario(@PathVariable Integer id){
        boolean eliminadoUsuario = usuarioService.eliminarUsuario(id);
        if(eliminadoUsuario) {
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("La id que me has pasado no le pertenece a ningun usuario");
        }
    }

    /**
     * Busca las citas de un usuario en concreto
     * @param id
     * @return
     */
    @GetMapping("/{id}/citas")
    public ResponseEntity<?> citasUsuario(@PathVariable Integer id){
        if(!usuarioRepository.existsById(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Usuario no encontrado");
        }
        Set<CitaResponseDTO> citas = new HashSet<>(citaService.citasUsuario(id));
        return ResponseEntity.ok(citas);
    }
}
