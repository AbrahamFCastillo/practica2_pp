package mx.smartkode.sk.crud.dao;

import java.util.List;

import mx.smartkode.sk.crud.model.Jugador;

public interface JugadorDao {
    public Integer ingresaJugador(Jugador jugador);
	
	public List<Jugador> consultaJugadores();
	
	public void actualizaJugador(Jugador jugador);
	
	public void eliminaJugador(Integer id);
	
	public Jugador consultaJugador(Integer id);

}
