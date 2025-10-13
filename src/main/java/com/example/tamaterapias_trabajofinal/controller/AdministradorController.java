package com.example.tamaterapias_trabajofinal.controller;

import com.example.tamaterapias_trabajofinal.DTO.CitaResponseDTO;
import com.example.tamaterapias_trabajofinal.DTO.usuario.UsuarioRequestDTO;
import com.example.tamaterapias_trabajofinal.DTO.usuario.UsuarioResponsetDTO;
import com.example.tamaterapias_trabajofinal.modelo.Administrador;
import com.example.tamaterapias_trabajofinal.modelo.Cita;
import com.example.tamaterapias_trabajofinal.modelo.Producto;
import com.example.tamaterapias_trabajofinal.service.AdministradorService;
import com.example.tamaterapias_trabajofinal.service.CitaService;
import com.example.tamaterapias_trabajofinal.service.ProductoService;
import com.example.tamaterapias_trabajofinal.service.UsuarioService;
import com.sun.net.httpserver.HttpsServer;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/api/administradores")
@CrossOrigin(origins = "*")
public class AdministradorController {

    @Autowired
    private AdministradorService administradorService;

    /**
     * Cogemos usuario service, porque el admin, va a poder hacer todo lo posible con el usuario
     */
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private ProductoService productoService;
    @Autowired
    private CitaService citaService;

    /**
     * Lista a los administradores que hayan registrados en la bbdd
     * @return
     */

    @GetMapping
    public ResponseEntity<Set<Administrador>> getAdiminstradores(){
        return ResponseEntity.ok(administradorService.listarAdministradores());
    }

    /**
     * Crea un nuevo admin y si todo fue bie devuelve el cod 201
     * @param administrador
     */

    @PostMapping
    public ResponseEntity<Administrador> crearAdministrador(@RequestBody Administrador administrador){
        Administrador adminCreado = administradorService.crearAdministrador(administrador);
        return ResponseEntity.status(HttpStatus.CREATED).body(adminCreado);
    }

    /**
     * Eliminamos a un admin, según el id q nos pase
     * COD : 204 (No Content si fue correcto) 404 si no existe el adm
     * @param id
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarAdministrador(@PathVariable Integer id){

        boolean adminEliminado = administradorService.eliminarAdministrador(id);
        if(adminEliminado){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Admin no encontrado");
        }
    }

    /**
     * Busca un admin por el id que le pasemos
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<Administrador> buscarAdm(@PathVariable Integer id){
      return ResponseEntity.ok(administradorService.buscarPorId(id));
    }

    ///////// USUARIO //////

    /**
     * Crea un usuario, a partir del admin
     * @param usuario
     * @return
     */
    @PostMapping("/usuarios")
    public ResponseEntity<UsuarioResponsetDTO> crearUsuario(@RequestBody UsuarioRequestDTO usuario){
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.crearUsuario(usuario));
    }

    /**
     * Lista a los usuarios
     * @return
     */
    @GetMapping("/usuarios")
    public ResponseEntity<Set<UsuarioResponsetDTO>> listarUsuarios(){
        return ResponseEntity.ok(usuarioService.listarUsuarios());
    }

    /**
     * Elimina a un usuario, somos admin, podemos eliminar a alguien
     * @param id
     */
    @DeleteMapping("/usuarios/{id}")
    public void eliminarUsuario(@PathVariable Integer id){
        usuarioService.eliminarUsuario(id);
    }

    /*@GetMapping("/{id}")
    public UsuarioResponsetDTO buscarUsuario(@PathVariable Integer id){
        return usuarioService.buscarUsuarioID(id);
    }*/

    /// ///////////// Productos ////////////////

    /**
     * Crea un nuevo usuario
     * @param producto
     * @return
     */
    @PostMapping("/productos")
    public ResponseEntity<Producto> crearProducto(@RequestBody  Producto producto){
       return ResponseEntity.status(HttpStatus.CREATED).body(productoService.crearProducto(producto));
    }

    /**
     * Lista todos los productos que haya
     * @return
     */
    @GetMapping("/productos")
    public ResponseEntity<Set<Producto>> listarProductos(){
        return ResponseEntity.ok(productoService.listarProductos());
    }

    /**
     *Busca un producto según el id que le pasemos
     * @param id
     * @return
     */
    @GetMapping("/productos/{id}")
    public ResponseEntity<Producto> buscarProducto(@PathVariable Integer id){
        return ResponseEntity.ok(productoService.productoPorId(id));
    }


    /**
     * Elimina un producto según el id que le pasemos
     * @param id
     * @return
     */
    @DeleteMapping("/productos/{id}")
    public ResponseEntity<?> eliminarProducto(@PathVariable Integer id){
        productoService.eliminarProducto(id);
        return ResponseEntity.noContent().build();
    }

    /// /////// CITAS /////////

    @PostMapping("/citas")
    public ResponseEntity<CitaResponseDTO> crearCita(@RequestBody  Cita cita){
       CitaResponseDTO citaResponseDTO = citaService.crearCita(cita);
       return ResponseEntity.status(HttpStatus.CREATED).body(citaResponseDTO);
    }

    @GetMapping("/citas")
    public ResponseEntity<Set<CitaResponseDTO>> listarCita(){
        return ResponseEntity.ok(citaService.listarCitas());
    }

    @DeleteMapping("/citas/{id}")
    public ResponseEntity<?> eliminarCita(@PathVariable Integer id){

        boolean citaEliminada = citaService.eliminarCita(id);
        if(citaEliminada){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("cita no encontrada");
        }

    }

    @GetMapping("/citas/{id}")
    public ResponseEntity<CitaResponseDTO> buscarCita(@PathVariable Integer id){
        return ResponseEntity.ok(citaService.bucarCitaID(id));
    }

}
