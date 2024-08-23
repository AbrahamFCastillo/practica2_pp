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
import mx.smartkode.sk.crud.model.Jugador;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"classpath:/config/spring/appContext-service.xml"})

public class JugadorServiceTest {
    
    @Autowired
    private JugadorService jugadorService;

    public Log log = LogFactory.getLog(JugadorServiceTest.class);

    @Test
	public void ingresaJugadorTest(){
		Assert.assertNotNull(jugadorService);
		
		try {
			Jugador jugador = new Jugador();
			jugador.setUsername("killer666");
			jugador.setEmail("killer666@ejemplo.com");
			
			jugadorService.ingresaJugador(jugador);
			Assert.assertTrue(true);
		} catch (ServiceException e) {
			log.error(e.getCodigoError()+" - "+e.getMensaje());
			Assert.fail(e.getCodigoError()+" - "+e.getMensaje());
		}	
	}

    @Test
	public void consultaJugadoresTest(){
		Assert.assertNotNull(jugadorService);
		List<Jugador> jugadores = null;
		
		try {
			jugadores=jugadorService.consultaJugadores();	
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
		Assert.assertNotNull(jugadorService);
		Jugador jugador = null;
		
		try {
			jugador=jugadorService.consultaJugador(5);
			Assert.assertNotNull(jugador);
			log.info(jugador.toString());
		} catch (Exception e) {
			log.error(e);
			Assert.fail(e.getMessage());
		}
	}

    @Test
	public void actualizaJugador(){
		Assert.assertNotNull(jugadorService);
		
		try {
			Jugador jugador = new Jugador();
			jugador.setId(6);
			jugador.setUsername("donvito");
			jugador.setEmail("donvito@ejemplo.com");
			
			jugadorService.actualizaJugador(jugador);
			Assert.assertTrue(true);
		} catch (Exception e) {
			log.error(e);
			Assert.fail(e.getMessage());
		}
				
	}

    @Test
	public void eliminaJugador(){ 
		Assert.assertNotNull(jugadorService);
		
		try {
			jugadorService.eliminaJugador(7); //se ejecuta antes de la consulta al mismo id
			Assert.assertTrue(true);
		} catch (Exception e) {
			log.error(e);
			Assert.fail(e.getMessage());
		}
		
	}
}
