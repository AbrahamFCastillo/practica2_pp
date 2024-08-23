package mx.smartkode.sk.crud.dao.impl;


import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import mx.smartkode.sk.crud.model.Alumno;
import mx.smartkode.sk.crud.dao.AlumnoDao;

@Repository ("alumnoDao")
public class AlumnoDaoImpl extends SqlSessionDaoSupport implements AlumnoDao {

	public Integer ingresaAlumno(Alumno alumno) {
		getSqlSession().insert("ingresaAlumno", alumno);
		return (Integer) 2;
	}

	public List<Alumno> consultaAlumnos() {
		return getSqlSession().selectList("consultaAlumnos");
	}


}
