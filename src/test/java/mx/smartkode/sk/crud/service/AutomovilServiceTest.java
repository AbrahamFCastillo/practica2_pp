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
import mx.smartkode.sk.crud.model.Automovil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"classpath:/config/spring/appContext-service.xml"})

public class AutomovilServiceTest {
    
    @Autowired
    private AutomovilService automovilService;

    public Log log = LogFactory.getLog(AutomovilServiceTest.class);

    @Test
	public void ingresaAutomovilTest(){
		Assert.assertNotNull(automovilService);
		
		try {
			Automovil automovil = new Automovil();
			automovil.setMarca("Chevrolet");  
			automovil.setModelo("Camaro");
            automovil.setanioFabricacion(1979);
			
			automovilService.ingresaAutomovil(automovil);
			Assert.assertTrue(true);
		} catch (ServiceException e) {
			log.error(e.getCodigoError()+" - "+e.getMensaje());
			Assert.fail(e.getCodigoError()+" - "+e.getMensaje());
		}	
	}

    @Test
	public void consultaAutomovilesTest(){
		Assert.assertNotNull(automovilService);
		List<Automovil> automoviles = null;
		
		try {
			automoviles=automovilService.consultaAutomoviles();	
			Assert.assertNotNull(automoviles);
			for (Automovil automovil : automoviles) {
				log.info(automovil.toString());
			}
		} catch (Exception e) {
			log.error(e);
			Assert.fail(e.getMessage());
		}
	}

    @Test
	public void consultaAutomovilTest(){
		Assert.assertNotNull(automovilService);
		Automovil automovil = null;
		
		try {
			automovil=automovilService.consultaAutomovil(5);
			Assert.assertNotNull(automovil);
			log.info(automovil.toString());
		} catch (Exception e) {
			log.error(e);
			Assert.fail(e.getMessage());
		}
	}

    @Test
	public void actualizaAutomovil(){
		Assert.assertNotNull(automovilService);
		
		try {
			Automovil automovil = new Automovil();
			automovil.setId(15);
			automovil.setMarca("Ford");
			automovil.setModelo("Mustang");
            automovil.setanioFabricacion(2005);
			
			automovilService.actualizaAutomovil(automovil);
			Assert.assertTrue(true);
		} catch (Exception e) {
			log.error(e);
			Assert.fail(e.getMessage());
		}
				
	}

    @Test
	public void eliminaAutomovil(){ 
		Assert.assertNotNull(automovilService);
		
		try {
			automovilService.eliminaAutomovil(7); //se ejecuta antes de la consulta al mismo id
			Assert.assertTrue(true);
		} catch (Exception e) {
			log.error(e);
			Assert.fail(e.getMessage());
		}
		
	}
}
