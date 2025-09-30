package com.example.tamaterapias_trabajofinal.service;

import com.example.tamaterapias_trabajofinal.controller.ProductoController;
import com.example.tamaterapias_trabajofinal.modelo.Producto;
import com.example.tamaterapias_trabajofinal.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    //Crear producto pasándolo por parámetro
    public Producto crearProducto(Producto producto){
        return productoRepository.save(producto);
    }

    //Elimina producto a través de un id
    public void eliminarProducto(Integer id){
        productoRepository.deleteById(id);
    }

    //Lista todos los proudctos

    public List<Producto> listarProductos(){
        return productoRepository.findAll();
    }

    //Busca un producto por su id (importante!!!)
   public Producto productoPorId(Integer id){
        return productoRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Producto no encontrado"));
   }

    public Producto guardarProducto(Producto producto){
        return productoRepository.save(producto);
    }
}
