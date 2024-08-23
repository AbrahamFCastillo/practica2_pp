package mx.smartkode.sk.crud.dao;


import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mx.smartkode.sk.crud.model.Alumno;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"classpath:/config/spring/appContext-repository.xml"})

public class AlumnoDaoTest {
	
	@Autowired
	private AlumnoDao alumnoDao;
	
	public Log log = LogFactory.getLog(AlumnoDaoTest.class);
	
	@Test
	public void ingresaAlumnoTest(){ 
		Assert.assertNotNull(alumnoDao); 
		
		try {
			float prom=9;
			Alumno alumno = new Alumno();
			alumno.setNombre("AMLO");
			alumno.setPromedio(prom);;
			alumno.setEdad(25);
			
			alumnoDao.ingresaAlumno(alumno);
			Assert.assertTrue(true);
		} catch (Exception e) {
			log.error(e);
			Assert.fail(e.getMessage());
		}
				
	}
	
	@Test
	public void consultaAlumnosTest(){
		Assert.assertNotNull(alumnoDao);
		List<Alumno> alumnos = null;
		
		try {
			alumnos=alumnoDao.consultaAlumnos();	
			Assert.assertNotNull(alumnos);
			for (Alumno alumno : alumnos) {
				log.info(alumno.toString());
			}
		} catch (Exception e) {
			log.error(e);
			Assert.fail(e.getMessage());
		}
		
	}
	
	



}
