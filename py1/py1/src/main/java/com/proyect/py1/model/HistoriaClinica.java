package com.proyect.py1.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class HistoriaClinica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idHistoriaClinica;
    private String fechaCreacion;
    private String fechaModificacion;

    @ManyToOne
    private Paciente paciente;

    @OneToMany(mappedBy = "historiaClinica")
    private List<Consulta> consultas;
}
