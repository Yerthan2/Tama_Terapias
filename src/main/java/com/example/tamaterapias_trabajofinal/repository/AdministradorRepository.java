package com.example.tamaterapias_trabajofinal.repository;

import com.example.tamaterapias_trabajofinal.modelo.Administrador;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministradorRepository extends JpaRepository<Administrador, Integer> {
}
