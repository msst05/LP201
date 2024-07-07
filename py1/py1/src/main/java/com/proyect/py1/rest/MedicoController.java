package com.proyect.py1.rest;
import com.proyect.py1.DTO.MedicoDTO;
import com.proyect.py1.model.Medico;
import com.proyect.py1.model.Paciente;
import com.proyect.py1.services.IMedicoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class MedicoController {
    IMedicoServices _medicoServices;

    @Autowired
    public MedicoController(IMedicoServices medicoServices) {
        this._medicoServices = medicoServices;
    }

    @GetMapping("/Medico")
    public List<Medico> geMedicos() {
        return _medicoServices.listar();
    }

    @GetMapping("/Medico/{idMedico}")
    public Medico buascarMedico(@PathVariable int idMedico)  {

        return (Medico) _medicoServices.buascarMedico(idMedico);
    }


    @PostMapping("/Medico")
    public Medico savePet(@RequestBody MedicoDTO medico) {
        return _medicoServices.guardarMedico(medico);
    }

    @PutMapping("/Medico")
    public Medico updatePet(@RequestBody MedicoDTO medico) {
        return _medicoServices.actualizarMedico(medico);
    }

    @DeleteMapping("/Medico/{id}")
    public Medico deletePetById(@PathVariable int id) {
        return _medicoServices.DeleteMedicoById(id);
    }





}
