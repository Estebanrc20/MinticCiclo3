package com.proyecto.examproyecto.repository;

import com.proyecto.examproyecto.entity.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Empleado, Long> {
}
