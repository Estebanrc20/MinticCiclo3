package com.proyecto.examproyecto.repository;

import com.proyecto.examproyecto.entity.MovimientoDinero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimientoRepository extends JpaRepository<MovimientoDinero, Long> {
}
