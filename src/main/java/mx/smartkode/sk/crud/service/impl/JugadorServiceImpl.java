package mx.smartkode.sk.crud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import mx.smartkode.sk.crud.Constantes;
import mx.smartkode.sk.crud.dao.JugadorDao;
import mx.smartkode.sk.crud.exception.ServiceException;
import mx.smartkode.sk.crud.model.Jugador;
import mx.smartkode.sk.crud.service.JugadorService;

@Service("jugadorService")
public class JugadorServiceImpl implements JugadorService{
    @Autowired
    private JugadorDao jugadorDao;

	public Log log = LogFactory.getLog(JugadorServiceImpl.class);

    @Override
    public Integer ingresaJugador(Jugador jugador) throws ServiceException {
        Integer id = null;
        try {
            id = jugadorDao.ingresaJugador(jugador);
        } catch (Exception e) {
            log.error("ERROR EN CAPA DE SERVICIO: "+e.getMessage());
			throw new ServiceException(Constantes.ERROR_AGREGAR, "Error al agregar jugador");
        }
        return id;
    }

    @Override
    public List<Jugador> consultaJugadores() throws ServiceException {
        List<Jugador> jugadores = null;
		try {
			jugadores = jugadorDao.consultaJugadores();
		} catch (Exception e) {
			log.error("ERROR EN CAPA DE SERVICIO: "+e.getMessage());
			throw new ServiceException(Constantes.ERROR_CONSULTA, "Error al consultar registros");
		}
		return jugadores;    
    }

    @Override
    public void actualizaJugador(Jugador jugador) throws ServiceException {
        try {
            if (jugador.getId() == null) {
				throw new RuntimeException("Es requerido el ID.");
            }
            else {
                Jugador consulta = this.consultaJugador(jugador.getId());
                if (consulta == null) {
					throw new RuntimeException("El jugador no existe."); 
                }
                jugadorDao.actualizaJugador(jugador);
            }
        } catch (Exception e) {
            log.error("ERROR EN CAPA DE SERVICIO: "+e.getMessage());
			if(e instanceof RuntimeException) {
				throw new ServiceException(Constantes.ERROR_EDITAR, "Error al actualizar jugador, "+e.getMessage());
			}
			throw new ServiceException(Constantes.ERROR_EDITAR, "Error al actualizar jugador");
        }    
    }

    @Override
    public void eliminaJugador(Integer id) throws ServiceException {
        try {
			jugadorDao.eliminaJugador(id);
		} catch (Exception e) {
			log.error("ERROR EN CAPA DE SERVICIO: "+e.getMessage());
			throw new ServiceException(Constantes.ERROR_EDITAR, "Error al eliminar jugador");
		}
    }

    @Override
    public Jugador consultaJugador(Integer id) throws ServiceException {
        Jugador jugador = null;
		try {
			jugador = jugadorDao.consultaJugador(id);
		} catch (Exception e) {
			log.error("ERROR EN CAPA DE SERVICIO: "+e.getMessage());
			throw new ServiceException(Constantes.ERROR_CONSULTA, "Error al consultar registro");
		}
		return jugador;
    }
    
}
