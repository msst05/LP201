package com.cibertec.springPC1.repository_i202224095;

import com.cibertec.springPC1.model_i202224095.Alumnos_i202224095;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAlumnosRepository extends JpaRepository<Alumnos_i202224095,Integer> {
}
