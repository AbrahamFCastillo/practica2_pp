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

import mx.smartkode.sk.crud.model.Jugador;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"classpath:/config/spring/appContext-repository.xml"})

public class JugadorDaoTest {

    @Autowired
	private JugadorDao jugadorDao;
	
	public Log log = LogFactory.getLog(JugadorDaoTest.class);

    @Test
	public void ingresaJugadorTest(){ 
		Assert.assertNotNull(jugadorDao);
		
		try {
			Jugador jugador = new Jugador();
			//jugador.setId(1);
			jugador.setUsername("killer666");
			jugador.setEmail("killer666@ejemplo.com");

			jugadorDao.ingresaJugador(jugador);
			Assert.assertTrue(true);
		} catch (Exception e) {
			log.error(e);
			Assert.fail(e.getMessage());
		}			
	}

    @Test
	public void consultaJugadoresTest(){
		Assert.assertNotNull(jugadorDao);
		List<Jugador> jugadores = null;
		
		try {
			jugadores=jugadorDao.consultaJugadores();	
			Assert.assertNotNull(jugadores);
			for (Jugador jugador : jugadores) {
				log.info(jugador.toString());
			}
		} catch (Exception e) {
			log.error(e);
			Assert.fail(e.getMessage());
		}
	}

    @Test
	public void consultaJugadorTest(){
		Assert.assertNotNull(jugadorDao);
		Jugador jugador = null;
		
		try {
			jugador=jugadorDao.consultaJugador(1);
			Assert.assertNotNull(jugador);
			log.info(jugador.toString());
		} catch (Exception e) {
			log.error(e);
			Assert.fail(e.getMessage());
		}	
	}

    @Test
	public void actualizaJugador(){
		Assert.assertNotNull(jugadorDao);
		
		try {
			Jugador jugador = new Jugador();
			jugador.setId(2);
			jugador.setUsername("donvito");
			jugador.setEmail("donvito@ejemplo.com");
			
			jugadorDao.actualizaJugador(jugador);
			Assert.assertTrue(true);
		} catch (Exception e) {
			log.error(e);
			Assert.fail(e.getMessage());
		}			
	}

    @Test
	public void eliminaJugador(){
		Assert.assertNotNull(jugadorDao);
		
		try {
			jugadorDao.eliminaJugador(3);
			Assert.assertTrue(true);
		} catch (Exception e) {
			log.error(e);
			Assert.fail(e.getMessage());
		}
		
	}
}
