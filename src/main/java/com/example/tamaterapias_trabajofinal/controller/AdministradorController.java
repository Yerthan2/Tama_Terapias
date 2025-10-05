package com.example.tamaterapias_trabajofinal.controller;

import com.example.tamaterapias_trabajofinal.DTO.UsuarioRequestDTO;
import com.example.tamaterapias_trabajofinal.DTO.UsuarioResponsetDTO;
import com.example.tamaterapias_trabajofinal.modelo.Administrador;
import com.example.tamaterapias_trabajofinal.modelo.Cita;
import com.example.tamaterapias_trabajofinal.modelo.Producto;
import com.example.tamaterapias_trabajofinal.modelo.Usuario;
import com.example.tamaterapias_trabajofinal.service.AdministradorService;
import com.example.tamaterapias_trabajofinal.service.CitaService;
import com.example.tamaterapias_trabajofinal.service.ProductoService;
import com.example.tamaterapias_trabajofinal.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/administradores")
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

    @GetMapping
    public Set<Administrador> getAdiminstradores(){
        return administradorService.listarAdministradores();
    }

    @PostMapping
    public void crearAdministrador(@RequestBody Administrador administrador){

        administradorService.crearAdministrador(administrador);
    }

    @DeleteMapping("/{id}")
    public void eliminarAdministrador(@PathVariable Integer id){
        administradorService.eliminarAdministrador(id);
    }

    @GetMapping("/{id}")
    public Administrador buscarAdm(@PathVariable Integer id){
       return administradorService.buscarPorId(id);
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
    public Cita crearCita(@RequestBody  Cita cita){
        return citaService.crearCita(cita);
    }

    @GetMapping("/citas")
    public Set<Cita> listarCita(){
        return new HashSet<>(citaService.listarCitas());
    }

    @DeleteMapping("/citas/{id}")
    public void eliminarCita(@PathVariable Integer id){
        citaService.eliminarCita(id);
    }

    @GetMapping("/citas/{id}")
    public Cita buscarCita(@PathVariable Integer id){
        return citaService.bucarCitaID(id);
    }

}
