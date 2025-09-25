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

    public Producto actualizarProducto(Integer id, Producto productoNuevoActualizado){
        Producto producto = productoPorId(id);

        if(productoNuevoActualizado.getNombreProducto() != null){
            producto.setNombreProducto(productoNuevoActualizado.getNombreProducto());
        }
        if (productoNuevoActualizado.getPrecio() != 0){
            producto.setPrecio(productoNuevoActualizado.getPrecio());
        }
        if(productoNuevoActualizado.getImagen() != null){
            producto.setImagen(productoNuevoActualizado.getImagen());
        }
        if(productoNuevoActualizado.getDetalles() != null){
            producto.setImagen(productoNuevoActualizado.getDetalles().toString());
        }
        if(productoNuevoActualizado.getDescripcion() != null){
            producto.setDescripcion(productoNuevoActualizado.getDescripcion());
        }


        return productoRepository.save(producto);
    }

}
