package com.cibertec.springPC1.services_i202224095;
import java.util.List;
import com.cibertec.springPC1.model_i202224095.Alumnos_i202224095;

public interface IAlumnoServices {
    List<Alumnos_i202224095> listarAlumnos();
    Alumnos_i202224095 grabarAlumno(Alumnos_i202224095 entity);
    Alumnos_i202224095 buscarAlumnosId(int id);
    void eliminarAlumnoId(int id);
    Alumnos_i202224095 actualizarAlumno(int id, Alumnos_i202224095 actuAlumno);
}

