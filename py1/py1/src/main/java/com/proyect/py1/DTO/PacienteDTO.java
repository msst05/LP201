package com.proyect.py1.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PacienteDTO {
    private int idPaciente;
    private String nombre;
    private String apellido;
    private String fechaNacimiento;
    private String sexo;
    private String direccion;
    private String telefono;
    private String email;
    private String dni;
}
