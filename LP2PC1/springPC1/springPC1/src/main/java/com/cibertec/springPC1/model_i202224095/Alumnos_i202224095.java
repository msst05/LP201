package com.cibertec.springPC1.model_i202224095;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Alumnos_i202224095 {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idAlumno;
    private String nombreAlumno;
    private String apellidoAlumno;
    private int edadAlumno;
    private String sexoAlumno;
    private String correoAlumno;
    private String telefonoAlumno;

}
