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
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/usuarios")
    public UsuarioResponsetDTO crearUsuario(@RequestBody UsuarioRequestDTO usuario){
        return usuarioService.crearUsuario(usuario);
    }

    @GetMapping("/usuarios")
    public Set<UsuarioResponsetDTO> listarUsuarios(){
        return usuarioService.listarUsuarios();
    }

    @DeleteMapping("/usuarios/{id}")
    public void eliminarUsuario(@PathVariable Integer id){
        usuarioService.eliminarUsuario(id);
    }

    /*@GetMapping("/{id}")
    public UsuarioResponsetDTO buscarUsuario(@PathVariable Integer id){
        return usuarioService.buscarUsuarioID(id);
    }*/

    /// ///////////// Productos ////////////////

    @PostMapping("/productos")
    public Producto crearProducto(@RequestBody  Producto producto){
        return productoService.crearProducto(producto);
    }

    @GetMapping("/productos")
    public Set<Producto> listarProductos(){
        return new HashSet<>(productoService.listarProductos());
    }

    @GetMapping("/productos/{id}")
    public Producto buscarProducto(@PathVariable Integer id){
        return productoService.productoPorId(id);
    }

    @DeleteMapping("/productos/{id}")
    public void eliminarProducto(@PathVariable Integer id){
        productoService.eliminarProducto(id);
    }

    /// /////// CITAS /////////

    @PostMapping("/citas")
    public CitaResponseDTO crearCita(@RequestBody  Cita cita){
        return citaService.crearCita(cita);
    }

    @GetMapping("/citas")
    public Set<CitaResponseDTO> listarCita(){
        return new HashSet<>(citaService.listarCitas());
    }

    @DeleteMapping("/citas/{id}")
    public void eliminarCita(@PathVariable Integer id){
        citaService.eliminarCita(id);
    }

    @GetMapping("/citas/{id}")
    public CitaResponseDTO buscarCita(@PathVariable Integer id){
        return citaService.bucarCitaID(id);
    }

}
