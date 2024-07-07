package com.proyect.py1.repository;

import com.proyect.py1.model.HistoriaClinica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHistoriaClinicaRepository  extends JpaRepository<HistoriaClinica,Integer> {

}
