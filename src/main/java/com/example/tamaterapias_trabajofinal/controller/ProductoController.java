package com.example.tamaterapias_trabajofinal.controller;

import com.example.tamaterapias_trabajofinal.modelo.Producto;
import com.example.tamaterapias_trabajofinal.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public List<Producto> getProductos(){
        return productoService.listarProductos();
    }

    @PostMapping
    public Producto crearProducto(Producto producto){
        return productoService.guardarProducto(producto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtenerProductoId(Integer id){
        Producto p = productoService.productoPorId(id);
        if(p == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(p);
    }

    @DeleteMapping("/{id}")
    public void eliminarProducto(Integer id){
        productoService.eliminarProducto(id);
    }


}
