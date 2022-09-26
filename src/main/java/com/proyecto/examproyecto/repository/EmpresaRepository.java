package com.proyecto.examproyecto.repository;

import com.proyecto.examproyecto.entity.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
}
