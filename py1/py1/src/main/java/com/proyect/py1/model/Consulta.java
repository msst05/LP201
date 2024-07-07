package com.proyect.py1.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idConsulta;
    private String fechaCon sulta;
    private String motivoConsulta;
    private String diagnostico;
    private String tratamiento;

    @ManyToOne
    private HistoriaClinica historiaClinica;

    @ManyToOne
    private Medico medico;

    @OneToMany(mappedBy = "consulta")
    private List<Receta> recetas;

    @OneToMany(mappedBy = "consulta")
    private List<Examen> examenes;
}
