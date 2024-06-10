package com.cibertec.springPC1.rest_i202224095;

import com.cibertec.springPC1.model_i202224095.Alumnos_i202224095;
import com.cibertec.springPC1.services_i202224095.IAlumnoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AlumnoController {
    IAlumnoServices alumnoServices;

@Autowired
public AlumnoController(IAlumnoServices alumnoServices) {
    this.alumnoServices = alumnoServices;
}
@GetMapping("/alumnos")
    public List<Alumnos_i202224095> getAlumnos() {
    return alumnoServices.listarAlumnos();
}
@GetMapping("/alumnos/{id}")
    public Alumnos_i202224095 getAlumno(@PathVariable int id) {
    return  alumnoServices.buscarAlumnosId(id);
}
@PostMapping("/alumnos")
    public Alumnos_i202224095 saveAlumno(@RequestBody Alumnos_i202224095 entity) {
    return  alumnoServices.grabarAlumno(entity);
}
@DeleteMapping("/alumnos/{id}")
    public void removerAlumno(@PathVariable int id) {
    alumnoServices.eliminarAlumnoId(id);
}
@PutMapping("alumnos/{id}")
public Alumnos_i202224095 updateAlumno(@PathVariable int id, @RequestBody Alumnos_i202224095 actualizarAlumno) {
    return alumnoServices.actualizarAlumno(id, actualizarAlumno);
}

}
