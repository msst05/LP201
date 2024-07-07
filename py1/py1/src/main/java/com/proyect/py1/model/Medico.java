package com.proyect.py1.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMedico;
    private String nombre;
    private String apellido;
    private String especialidad;
    private String telefono;
    private String email;

    @OneToMany(mappedBy = "medico")
    private List<Consulta> consultas;
}
