package com.proyect.py1.services;
import com.proyect.py1.DTO.RecetaDTO;
import com.proyect.py1.model.Medico;
import com.proyect.py1.model.Receta;

import java.util.List;

public interface IRecetaServices {

    List<Receta> listar();
    Receta buascarReceta(int idReceta);
    Receta guardarReceta(RecetaDTO receta);
    Receta actualizarReceta( RecetaDTO receta);
    Receta DeleteRecetaById(int idReceta);

}
