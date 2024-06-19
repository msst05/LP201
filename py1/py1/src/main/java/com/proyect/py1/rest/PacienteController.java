package com.proyect.py1.rest;

import com.proyect.py1.DTO.PacienteDTO;
import com.proyect.py1.model.Paciente;
import com.proyect.py1.services.IPacienteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PacienteController {
    IPacienteServices  _pacienteServices;
    @Autowired
    public PacienteController(IPacienteServices pacienteServices) {
        this._pacienteServices = pacienteServices;
    }

    @GetMapping("/paciente")
    public List<Paciente> getPacientes() {
        return _pacienteServices.listar();
    }
    @PostMapping("/paciente")
    public Paciente savePaciente(@RequestBody PacienteDTO pacienteDTO) {
        return _pacienteServices.guardarPaciente(pacienteDTO);
    }
}
