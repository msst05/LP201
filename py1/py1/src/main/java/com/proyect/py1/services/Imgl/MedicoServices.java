package com.proyect.py1.services.Imgl;

import com.proyect.py1.DTO.MedicoDTO;
import com.proyect.py1.model.Medico;
import com.proyect.py1.repository.IMedicoRepository;
import com.proyect.py1.services.IMedicoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MedicoServices implements IMedicoServices {

    IMedicoRepository _medicoRepository;

    @Autowired
    public MedicoServices(IMedicoRepository medicoRepository) {
        _medicoRepository = medicoRepository;
    }


    @Override
    public List<Medico> listar() {
        return _medicoRepository.findAll();
    }




    @Override
    public Medico buascarMedico(int idMedico) {
        Optional<Medico> rowInDB = _medicoRepository.findById(idMedico);
        if (rowInDB.isPresent())
            return rowInDB.get();
        else
            return new Medico();
    }





    @Override
    public Medico guardarMedico(MedicoDTO medico) {
        Medico medico_ = new Medico();

        medico_.setNombre(medico.getNombre());
        medico_.setApellido(medico.getApellido());
        medico_.setTelefono(medico.getTelefono());
        medico_.setEmail(medico.getEmail());
        medico_.setEspecialidad(medico.getEspecialidad());

        medico_.setConsultas(new ArrayList<>());

        return _medicoRepository.save(medico_ );    }

    @Override
    public Medico actualizarMedico( MedicoDTO medico) {
        Optional<Medico> rowInDB = _medicoRepository.findById(medico.getIdMedico());
        if (rowInDB.isPresent()) {
            Medico estudianteToUpdate = rowInDB.get();
            // Actualizar los campos del estudiante
            estudianteToUpdate.setNombre(medico.getNombre());
            estudianteToUpdate.setApellido(medico.getApellido());
            estudianteToUpdate.setEmail(medico.getEmail());
            estudianteToUpdate.setEspecialidad(medico.getEspecialidad());
            return _medicoRepository.save(estudianteToUpdate);
        } else {
            // Manejo del caso en que el estudiante no exista
            return new Medico();
        }    }

    @Override
    public Medico DeleteMedicoById(int idMedico) {
        Optional<Medico> rowInDB = _medicoRepository.findById(idMedico);
        if (rowInDB.isPresent()) {
            Medico medicoToDelete = rowInDB.get();
            _medicoRepository.delete(medicoToDelete);
            return medicoToDelete;
        } else {
            // Manejo del caso en que el estudiante no exista
            return new Medico();
        }    }
}
