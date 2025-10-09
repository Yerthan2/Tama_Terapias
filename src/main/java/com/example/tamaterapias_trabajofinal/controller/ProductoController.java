package com.example.tamaterapias_trabajofinal.controller;

import com.example.tamaterapias_trabajofinal.modelo.Producto;
import com.example.tamaterapias_trabajofinal.service.ProductoService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = "*")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    /**
     * Buscp y devuelvo todos los productos que tenemos
     * @return
     */
    @GetMapping
    public ResponseEntity<Set<Producto>> getProductos(){
        Set<Producto> productos = new HashSet<>(productoService.listarProductos());
        return ResponseEntity.ok(productos);
    }

    /**
     * Crea un producto, si devuelve 201 fue creardo y guardado
     * @param producto
     * @return
     */
    @PostMapping
    public ResponseEntity<Producto> crearProducto(@RequestBody Producto producto){
        Producto productoNuevo = productoService.crearProducto(producto);
        return ResponseEntity.status(HttpStatus.CREATED).body(productoNuevo);
    }

    /**
     * Devuelve el producto que le hayamos pasado
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtenerProductoId(@PathVariable Integer id){
        Producto producto = productoService.productoPorId(id);
        return ResponseEntity.ok(producto);
    }

    /**
     * Elimina el producto que le pasemos por id
     * COD : 204 se ha borrado y 404 no encontrado
     * @param id
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarProducto(@PathVariable Integer id){
        boolean eliminado = productoService.eliminarProducto(id);
        if (eliminado) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Producto no encontrado con id: " + id);
        }
    }





}
