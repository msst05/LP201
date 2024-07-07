package com.proyect.py1.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class RecetaDTO {
    private int idReceta;
    private String fechaEmision;
    private String medicamentos;
}
