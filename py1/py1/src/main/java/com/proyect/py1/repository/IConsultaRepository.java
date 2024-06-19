package com.proyect.py1.repository;

import com.proyect.py1.model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IConsultaRepository extends JpaRepository<Consulta, Integer> {
}
