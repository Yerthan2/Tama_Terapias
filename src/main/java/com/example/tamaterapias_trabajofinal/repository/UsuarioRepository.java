package com.example.tamaterapias_trabajofinal.repository;

import com.example.tamaterapias_trabajofinal.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
