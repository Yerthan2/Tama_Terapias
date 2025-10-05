package com.example.tamaterapias_trabajofinal.repository;

import com.example.tamaterapias_trabajofinal.modelo.Cita;
import com.example.tamaterapias_trabajofinal.modelo.EstadoCita;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public interface CitaRepository extends JpaRepository<Cita, Integer> {

    Set<Cita> findByUsuario_IdUsuario(Integer idUsuario);
    Set<Cita> findByEstado(EstadoCita estadoCita);
    Set<Cita> findByFechaBetween(LocalDateTime inicio, LocalDateTime fin);

    
}
