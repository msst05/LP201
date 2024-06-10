package com.cibertec.springPC1.services_i202224095.Impl_i202224095;

import com.cibertec.springPC1.model_i202224095.Alumnos_i202224095;
import com.cibertec.springPC1.repository_i202224095.IAlumnosRepository;
import com.cibertec.springPC1.services_i202224095.IAlumnoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlumnoServices implements IAlumnoServices {
    IAlumnosRepository _alumnosRepository;

    @Autowired
    public AlumnoServices(IAlumnosRepository alumnosRepository) {
        _alumnosRepository = alumnosRepository;
    }
    @Override
    public List<Alumnos_i202224095> listarAlumnos() {
        return _alumnosRepository.findAll();
    }



    @Override
    public Alumnos_i202224095 grabarAlumno(Alumnos_i202224095 nuevoalumno) {
        Alumnos_i202224095 alumno=_alumnosRepository.save(nuevoalumno);
        return alumno;
    }

    @Override
    public Alumnos_i202224095 buscarAlumnosId(int id) {
        Optional<Alumnos_i202224095> registroBD=_alumnosRepository.findById(id);
        if(registroBD.isPresent())
            return registroBD.get();
        else
            return new Alumnos_i202224095();
    }

    @Override
    public void eliminarAlumnoId(int id) {
        _alumnosRepository.deleteById(id);
    }

    @Override
    public Alumnos_i202224095 actualizarAlumno(int id, Alumnos_i202224095 actuAlumno) {
        Optional<Alumnos_i202224095> actualAlumnoOpt = _alumnosRepository.findById(id);
        if (actualAlumnoOpt.isPresent()) {
            Alumnos_i202224095 actualAlum = actualAlumnoOpt.get();
            actualAlum.setNombreAlumno(actuAlumno.getNombreAlumno());
            actualAlum.setApellidoAlumno(actuAlumno.getApellidoAlumno());
            actualAlum.setEdadAlumno(actuAlumno.getEdadAlumno());
            actualAlum.setSexoAlumno(actuAlumno.getSexoAlumno());
            actualAlum.setCorreoAlumno(actuAlumno.getCorreoAlumno());
            actualAlum.setTelefonoAlumno(actuAlumno.getTelefonoAlumno());
            return _alumnosRepository.save(actualAlum);

        } else {
            return new Alumnos_i202224095();
        }
        }

    }
