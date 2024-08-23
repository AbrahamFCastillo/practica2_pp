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

import mx.smartkode.sk.crud.model.Ciudad;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"classpath:/config/spring/appContext-repository.xml"})

public class CiudadDaoTest {

    @Autowired
	private CiudadDao ciudadDao;
	
	public Log log = LogFactory.getLog(CiudadDaoTest.class);

    @Test
	public void ingresaCiudadTest(){ 
		Assert.assertNotNull(ciudadDao);
		
		try {
			Ciudad ciudad = new Ciudad();
			ciudad.setNombre("Portland");
			ciudad.setPais("Estados Unidos");
            ciudad.setPoblacion(3000000);

			ciudadDao.ingresaCiudad(ciudad);
			Assert.assertTrue(true);
		} catch (Exception e) {
			log.error(e);
			Assert.fail(e.getMessage());
		}			
	}

    @Test
	public void consultaCiudadesTest(){
		Assert.assertNotNull(ciudadDao);
		List<Ciudad> ciudades = null;
		
		try {
			ciudades=ciudadDao.consultaCiudades();	
			Assert.assertNotNull(ciudades);
			for (Ciudad ciudad : ciudades) {
				log.info(ciudad.toString());
			}
		} catch (Exception e) {
			log.error(e);
			Assert.fail(e.getMessage());
		}
	}

    @Test
	public void consultaCiudadTest(){
		Assert.assertNotNull(ciudadDao);
		Ciudad ciudad = null;
		
		try {
			ciudad=ciudadDao.consultaCiudad(1);
			Assert.assertNotNull(ciudad);
			log.info(ciudad.toString());
		} catch (Exception e) {
			log.error(e);
			Assert.fail(e.getMessage());
		}	
	}

    @Test
	public void actualizaCiudad(){
		Assert.assertNotNull(ciudadDao);
		
		try {
			Ciudad ciudad = new Ciudad();
			ciudad.setId(2);
			ciudad.setNombre("Laredo");
			ciudad.setPais("Estados Unidos");
            ciudad.setPoblacion(2000000);
			
			ciudadDao.actualizaCiudad(ciudad);
			Assert.assertTrue(true);
		} catch (Exception e) {
			log.error(e);
			Assert.fail(e.getMessage());
		}			
	}

    @Test
	public void eliminaCiudad(){
		Assert.assertNotNull(ciudadDao);
		
		try {
			ciudadDao.eliminaCiudad(3);
			Assert.assertTrue(true);
		} catch (Exception e) {
			log.error(e);
			Assert.fail(e.getMessage());
		}
		
	}
}
