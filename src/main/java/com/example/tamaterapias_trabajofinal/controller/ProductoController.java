package com.example.tamaterapias_trabajofinal.controller;

import com.example.tamaterapias_trabajofinal.modelo.Producto;
import com.example.tamaterapias_trabajofinal.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public Set<Producto> getProductos(){
        return new HashSet<>(productoService.listarProductos());
    }

    @PostMapping
    public Producto crearProducto(@RequestBody Producto producto){
        return productoService.crearProducto(producto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtenerProductoId(@PathVariable Integer id){
        Producto p = productoService.productoPorId(id);
        if(p == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(p);
    }

    @DeleteMapping("/{id}")
    public void eliminarProducto(@PathVariable Integer id){
        productoService.eliminarProducto(id);
    }





}
