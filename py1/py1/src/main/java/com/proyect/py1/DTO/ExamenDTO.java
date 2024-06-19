package com.proyect.py1.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ExamenDTO {
    private int idExamen;
    private String tipoExamen;
    private String fechaSolicitud;
    private String resultados;
}
