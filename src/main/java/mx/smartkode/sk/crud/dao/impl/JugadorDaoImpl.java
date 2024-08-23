package mx.smartkode.sk.crud.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import mx.smartkode.sk.crud.dao.JugadorDao;
import mx.smartkode.sk.crud.model.Jugador;

@Repository("jugadorDao")
public class JugadorDaoImpl extends SqlSessionDaoSupport implements JugadorDao {

    @Override
    public Integer ingresaJugador(Jugador jugador) {
        getSqlSession().insert("ingresaJugador", jugador);
        return jugador.getId();
    }

    @Override
    public List<Jugador> consultaJugadores() {
        return getSqlSession().selectList("consultaJugadores");
    }

    @Override
    public void actualizaJugador(Jugador jugador) {
        getSqlSession().update("actualizaJugador", jugador);
    }

    @Override
    public void eliminaJugador(Integer id) {
		getSqlSession().delete("eliminaJugador", id);

    }

    @Override
    public Jugador consultaJugador(Integer id) {
        return getSqlSession().selectOne("consultaJugador", id);
    }

    
}
