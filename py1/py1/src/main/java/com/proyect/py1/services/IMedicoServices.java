package com.proyect.py1.services;
import com.proyect.py1.DTO.MedicoDTO;
import com.proyect.py1.model.Medico;

import java.util.List;
import java.util.Optional;

public interface IMedicoServices {
    List<Medico> listar();
    Medico buascarMedico(int idMedico);
    Medico guardarMedico(MedicoDTO medico);
    Medico actualizarMedico( MedicoDTO medico);
    Medico DeleteMedicoById(int idMedico);

}
