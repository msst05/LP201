package com.proyect.py1.repository;

import com.proyect.py1.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMedicoRepository extends JpaRepository<Medico, Integer> {
}
