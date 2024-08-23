package mx.smartkode.sk.crud.dao;

import java.util.List;

import mx.smartkode.sk.crud.model.Alumno;


public interface AlumnoDao {
	
    public Integer ingresaAlumno(Alumno alumno);
	
	public List<Alumno> consultaAlumnos();
	
}
