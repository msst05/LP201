package com.proyect.py1.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ConsultaDTO {
    private int idConsulta;
    private String fechaConsulta;
    private String motivoConsulta;
    private String diagnostico;
    private String tratamiento;
}
