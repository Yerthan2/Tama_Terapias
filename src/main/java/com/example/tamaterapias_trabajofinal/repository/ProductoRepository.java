package com.example.tamaterapias_trabajofinal.repository;

import com.example.tamaterapias_trabajofinal.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
}
