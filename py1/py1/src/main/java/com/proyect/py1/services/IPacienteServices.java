package com.proyect.py1.services;

import com.proyect.py1.DTO.PacienteDTO;
import com.proyect.py1.model.Paciente;

import java.util.List;

public interface IPacienteServices {
    List<Paciente> listar();
    List<Paciente> buascarPaciente(String nombre);
    Paciente guardarPaciente(PacienteDTO paciente);
    Paciente actualizarPaciente(int codigo, PacienteDTO paciente);
}
