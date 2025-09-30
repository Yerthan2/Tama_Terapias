package com.example.tamaterapias_trabajofinal.repository;

import com.example.tamaterapias_trabajofinal.modelo.Cita;
import com.example.tamaterapias_trabajofinal.modelo.EstadoCita;
import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface CitaRepository extends JpaRepository<Cita, Integer> {

    List<Cita> findByUsuario_IdUsuario(Integer idUsuario);
    List<Cita> findByEstado(EstadoCita estadoCita);
    List<Cita> findByFechaBetween(LocalDateTime inicio, LocalDateTime fin);

    LocalDateTime fecha(LocalDateTime fecha);
}
