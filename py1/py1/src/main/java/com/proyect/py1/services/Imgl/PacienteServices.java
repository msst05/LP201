package com.proyect.py1.services.Imgl;

import com.proyect.py1.DTO.PacienteDTO;
import com.proyect.py1.model.Paciente;
import com.proyect.py1.repository.IPacienteRepository;
import com.proyect.py1.services.IPacienteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteServices implements IPacienteServices {

    IPacienteRepository _pacienteRepository;

    @Autowired
    public PacienteServices(IPacienteRepository pacienteRepository) {
        _pacienteRepository = pacienteRepository;
    }

    @Override
    public List<Paciente> listar() {
        return _pacienteRepository.findAll();
    }

    @Override
    public List<Paciente> buascarPaciente(String nombre) {
        return  _pacienteRepository.findByNombre(nombre);





    }

    @Override
    public Paciente guardarPaciente(PacienteDTO pacienteDTO) {

            Paciente paciente = new Paciente();
            paciente.setNombre(pacienteDTO.getNombre());
            paciente.setApellido(pacienteDTO.getApellido());
            paciente.setFechaNacimiento(pacienteDTO.getFechaNacimiento());
            paciente.setSexo(pacienteDTO.getSexo());
            paciente.setDireccion(pacienteDTO.getDireccion());
            paciente.setTelefono(pacienteDTO.getTelefono());
            paciente.setEmail(pacienteDTO.getEmail());
            paciente.setDni(pacienteDTO.getDni());
            paciente.setHistoriasClinicas(new ArrayList<>());

            return _pacienteRepository.save(paciente);
    }

    @Override
    public Paciente actualizarPaciente(int idPaciente, PacienteDTO pacienteDTO) {
        Optional<Paciente> pacienteOp = _pacienteRepository.findById(idPaciente);
        if (pacienteOp.isPresent()) {
            Paciente paciente = pacienteOp.get();
            paciente.setNombre(pacienteDTO.getNombre());
            paciente.setApellido(pacienteDTO.getApellido());
            paciente.setDni(pacienteDTO.getDni());
            paciente.setDireccion(pacienteDTO.getDireccion());
            paciente.setTelefono(pacienteDTO.getTelefono());
            paciente.setEmail(pacienteDTO.getEmail());
            paciente.setFechaNacimiento(pacienteDTO.getFechaNacimiento());

            return _pacienteRepository.save(paciente);
        } else {
            throw new RuntimeException("Paciente no encontrado");
        }
    }


    @Override
    public Paciente DeletePacientetById(int id) {
        Optional<Paciente> rowInDB = _pacienteRepository.findById(id);
        if (rowInDB.isPresent()) {
            Paciente estudianteToDelete = rowInDB.get();
            _pacienteRepository.delete(estudianteToDelete);
            return estudianteToDelete;
        } else {
            // Manejo del caso en que el estudiante no exista
            return new Paciente();
        }
    }




}