package mx.smartkode.sk.crud.service;

import java.util.List;

import mx.smartkode.sk.crud.exception.ServiceException;
import mx.smartkode.sk.crud.model.Jugador;

public interface JugadorService {
    public Integer ingresaJugador(Jugador jugador) throws ServiceException;
	
	public List<Jugador> consultaJugadores() throws ServiceException; 
	
	public void actualizaJugador(Jugador jugador) throws ServiceException;
	
	public void eliminaJugador(Integer id) throws ServiceException;
	
	public Jugador consultaJugador(Integer id) throws ServiceException;
}
