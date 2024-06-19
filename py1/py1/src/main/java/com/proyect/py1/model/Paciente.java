package com.proyect.py1.model;

import com.proyect.py1.DTO.PacienteDTO;
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
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPaciente;
    private String nombre;
    private String apellido;
    private String fechaNacimiento;
    private String sexo;
    private String direccion;
    private String telefono;
    private String email;
    private String dni;

    @OneToMany(mappedBy = "paciente")
    private List<HistoriaClinica> historiasClinicas;
}
