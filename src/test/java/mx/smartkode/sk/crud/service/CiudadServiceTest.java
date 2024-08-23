package mx.smartkode.sk.crud.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mx.smartkode.sk.crud.exception.ServiceException;
import mx.smartkode.sk.crud.model.Ciudad;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"classpath:/config/spring/appContext-service.xml"})

public class CiudadServiceTest { 
    
    @Autowired
    private CiudadService ciudadService;

    public Log log = LogFactory.getLog(CiudadServiceTest.class);

    @Test
	public void ingresaCiudadTest(){
		Assert.assertNotNull(ciudadService);
		
		try {
			Ciudad ciudad = new Ciudad();
			ciudad.setNombre("Puebla");
			ciudad.setPais("Mexico");
            ciudad.setPoblacion(6000000);
			
			ciudadService.ingresaCiudad(ciudad);
			Assert.assertTrue(true);
		} catch (ServiceException e) {
			log.error(e.getCodigoError()+" - "+e.getMensaje());
			Assert.fail(e.getCodigoError()+" - "+e.getMensaje());
		}	
	}

    @Test
	public void consultaCiudadesTest(){
		Assert.assertNotNull(ciudadService);
		List<Ciudad> ciudades = null;
		
		try {
			ciudades=ciudadService.consultaCiudades();	
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
		Assert.assertNotNull(ciudadService);
		Ciudad ciudad = null;
		
		try {
			ciudad=ciudadService.consultaCiudad(5);
			Assert.assertNotNull(ciudad);
			log.info(ciudad.toString());
		} catch (Exception e) {
			log.error(e);
			Assert.fail(e.getMessage());
		}
	}

    @Test
	public void actualizaCiudad(){
		Assert.assertNotNull(ciudadService);
		
		try {
			Ciudad ciudad = new Ciudad();
			ciudad.setId(6);
			ciudad.setNombre("CDMX");
			ciudad.setPais("Mexico");
            ciudad.setPoblacion(10000000);
			
			ciudadService.actualizaCiudad(ciudad);
			Assert.assertTrue(true);
		} catch (Exception e) {
			log.error(e);
			Assert.fail(e.getMessage());
		}
				
	}

    @Test
	public void eliminaCiudad(){ 
		Assert.assertNotNull(ciudadService);
		
		try {
			ciudadService.eliminaCiudad(7); //se ejecuta antes de la consulta al mismo id
			Assert.assertTrue(true);
		} catch (Exception e) {
			log.error(e);
			Assert.fail(e.getMessage());
		}
		
	}
}
