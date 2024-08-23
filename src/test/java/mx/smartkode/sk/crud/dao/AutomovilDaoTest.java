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

import mx.smartkode.sk.crud.model.Automovil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"classpath:/config/spring/appContext-repository.xml"})

public class AutomovilDaoTest {

    @Autowired
	private AutomovilDao automovilDao;
	
	public Log log = LogFactory.getLog(AutomovilDaoTest.class);

    @Test
	public void ingresaAutomovilTest(){  
		Assert.assertNotNull(automovilDao);
		
		try {
			Automovil automovil = new Automovil();
			automovil.setMarca("Nissan");
			automovil.setModelo("Skyline");
            automovil.setanioFabricacion(2002);

			automovilDao.ingresaAutomovil(automovil);
			Assert.assertTrue(true);
		} catch (Exception e) {
			log.error(e);
			Assert.fail(e.getMessage());
		}			
	}

    @Test
	public void consultaAutomovilesTest(){
		Assert.assertNotNull(automovilDao);
		List<Automovil> automoviles = null;
		
		try {
			automoviles=automovilDao.consultaAutomoviles();	
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
		Assert.assertNotNull(automovilDao);
		Automovil automovil = null;
		
		try {
			automovil=automovilDao.consultaAutomovil(1);
			Assert.assertNotNull(automovil);
			log.info(automovil.toString());
		} catch (Exception e) {
			log.error(e);
			Assert.fail(e.getMessage());
		}	
	}

    @Test
	public void actualizaAutomovil(){
		Assert.assertNotNull(automovilDao);
		
		try {
			Automovil automovil = new Automovil();
			automovil.setId(6);
			automovil.setMarca("Dodge");
			automovil.setModelo("Challenger SRT8");
            automovil.setanioFabricacion(2009);
			
			automovilDao.actualizaAutomovil(automovil);
			Assert.assertTrue(true);
		} catch (Exception e) {
			log.error(e);
			Assert.fail(e.getMessage());
		}			
	}

    @Test
	public void eliminaAutomovil(){
		Assert.assertNotNull(automovilDao);
		
		try {
			automovilDao.eliminaAutomovil(3);
			Assert.assertTrue(true);
		} catch (Exception e) {
			log.error(e);
			Assert.fail(e.getMessage());
		}
		
	}
}
