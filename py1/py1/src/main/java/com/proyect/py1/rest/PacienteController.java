package com.proyect.py1.rest;

import com.proyect.py1.DTO.PacienteDTO;
import com.proyect.py1.model.Paciente;
import com.proyect.py1.services.IPacienteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/paciente/{nombre}")
    public Paciente  buascarPaciente(@PathVariable String nombre)  {

        return (Paciente) _pacienteServices.buascarPaciente(nombre);
    }
    @PostMapping("/paciente")
    public Paciente savePaciente(@RequestBody PacienteDTO pacienteDTO) {
        return _pacienteServices.guardarPaciente(pacienteDTO);
    }
}
