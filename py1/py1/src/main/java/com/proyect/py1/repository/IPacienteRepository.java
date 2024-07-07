package com.proyect.py1.repository;

import com.proyect.py1.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IPacienteRepository extends JpaRepository<Paciente,Integer> {
    List<Paciente> findByNombre(String nombre);
}
