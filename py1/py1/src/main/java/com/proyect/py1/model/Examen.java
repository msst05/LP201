package com.proyect.py1.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Examen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idExamen;
    private String tipoExamen;
    private String fechaSolicitud;
    private String resultados;

    @ManyToOne
    private Consulta consulta;
}
