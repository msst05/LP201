package com.proyect.py1.services.Imgl;

import com.proyect.py1.DTO.RecetaDTO;
import com.proyect.py1.model.Medico;
import com.proyect.py1.model.Receta;
import com.proyect.py1.repository.IMedicoRepository;
import com.proyect.py1.repository.IRecetaRepository;
import com.proyect.py1.services.IRecetaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RecetaServices implements IRecetaServices {

    IRecetaRepository _recetaRepository;

    @Autowired
    public RecetaServices(IRecetaRepository recetaRepository) {
        _recetaRepository = recetaRepository;
    }


    @Override
    public List<Receta> listar() {
        return _recetaRepository.findAll();
    }

    @Override
    public Receta buascarReceta(int idReceta) {
        Optional<Receta> rowInDB = _recetaRepository.findById(idReceta);
        if (rowInDB.isPresent())
            return rowInDB.get();
        else
            return new Receta();    }

    @Override
    public Receta guardarReceta(RecetaDTO receta) {
        Receta receta_ = new Receta();

        receta_.setMedicamentos(receta.getMedicamentos());
        receta_.setFechaEmision(receta.getFechaEmision());


        return _recetaRepository.save(receta_ );      }

    @Override
    public Receta actualizarReceta(RecetaDTO receta) {
        Optional<Receta> rowInDB = _recetaRepository.findById(receta.getIdReceta());
        if (rowInDB.isPresent()) {
            Receta recetaToUpdate = rowInDB.get();
            // Actualizar los campos del estudiante
            recetaToUpdate.setFechaEmision(receta.getFechaEmision());
            recetaToUpdate.setMedicamentos(receta.getMedicamentos());

            return _recetaRepository.save(recetaToUpdate);
        } else {
            // Manejo del caso en que el estudiante no exista
            return new Receta();
        }    }

    @Override
    public Receta DeleteRecetaById(int idReceta) {
        Optional<Receta> rowInDB = _recetaRepository.findById(idReceta);
        if (rowInDB.isPresent()) {
            Receta recetaToDelete = rowInDB.get();
            _recetaRepository.delete(recetaToDelete);
            return recetaToDelete;
        } else {
            // Manejo del caso en que el estudiante no exista
            return new Receta();
        }    }
}
