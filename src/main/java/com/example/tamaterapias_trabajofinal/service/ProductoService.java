package com.example.tamaterapias_trabajofinal.service;

import com.example.tamaterapias_trabajofinal.controller.ProductoController;
import com.example.tamaterapias_trabajofinal.modelo.Producto;
import com.example.tamaterapias_trabajofinal.repository.ProductoRepository;
import jakarta.persistence.SecondaryTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    /**
     * Crear producto pasándolo por parámetro
     */

    public Producto crearProducto(Producto producto){
        return productoRepository.save(producto);
    }

    /**
     * comprobamos si la id que nos han pasado, existe si existe, elimina y devuleve true
     * si no, devuelve false
     * @param id
     * @return
     */
    public boolean eliminarProducto(Integer id){
        if(productoRepository.existsById(id)){
            productoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    /**
     * Devuelve todos los productos que tenemos
     * @return
     */

    public Set<Producto> listarProductos(){
        return new HashSet<>(productoRepository.findAll());
    }

    /**
     * Buscamos un producto por su id, si no lo encuentra, devuelve un mensaje
     * @param id
     * @return
     */
   public Producto productoPorId(Integer id){
        return productoRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Producto no encontrado"));
   }


}
