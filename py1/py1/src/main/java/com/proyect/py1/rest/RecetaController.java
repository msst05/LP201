package com.proyect.py1.rest;
import com.proyect.py1.DTO.MedicoDTO;
import com.proyect.py1.DTO.RecetaDTO;
import com.proyect.py1.model.Medico;
import com.proyect.py1.model.Receta;
import com.proyect.py1.services.IMedicoServices;
import com.proyect.py1.services.IRecetaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class RecetaController {
    IRecetaServices _recetaServices;

    @Autowired
    public RecetaController(IRecetaServices recetaServices) {
        this._recetaServices = recetaServices;
    }

    @GetMapping("/Receta")
    public List<Receta> geRecetas() {
        return _recetaServices.listar();
    }

    @GetMapping("/Receta/{idReceta}")
    public Receta buascarReceta(@PathVariable int idReceta)  {

        return (Receta) _recetaServices.buascarReceta(idReceta);
    }


    @PostMapping("/Receta")
    public Receta saveReceta(@RequestBody RecetaDTO receta) {
        return _recetaServices.guardarReceta(receta);
    }

    @PutMapping("/Receta")
    public Receta updateReceta(@RequestBody RecetaDTO receta) {
        return _recetaServices.actualizarReceta(receta);
    }

    @DeleteMapping("/Receta/{idReceta}")
    public Receta deleteReceta(@PathVariable int id) {
        return _recetaServices.DeleteRecetaById(id);
    }





}
