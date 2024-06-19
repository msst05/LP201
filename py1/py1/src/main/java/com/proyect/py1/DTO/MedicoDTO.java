package com.proyect.py1.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class MedicoDTO {
    private int idMedico;
    private String nombre;
    private String apellido;
    private String especialidad;
    private String telefono;
    private String email;
}
