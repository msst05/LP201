package com.proyect.py1.repository;

import com.proyect.py1.model.Examen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IExamenRepository extends JpaRepository<Examen, Integer> {
}
