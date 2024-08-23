package mx.smartkode.sk.crud.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import mx.smartkode.sk.crud.dao.CiudadDao;
import mx.smartkode.sk.crud.model.Ciudad;

@Repository("ciudadDao")
public class CiudadDaoImpl extends SqlSessionDaoSupport implements CiudadDao {

    @Override
    public Integer ingresaCiudad(Ciudad Ciudad) {
        getSqlSession().insert("ingresaCiudad", Ciudad);
        return Ciudad.getId();
    }

    @Override
    public List<Ciudad> consultaCiudades() {
        return getSqlSession().selectList("consultaCiudades");
    }

    @Override
    public void actualizaCiudad(Ciudad Ciudad) {
        getSqlSession().update("actualizaCiudad", Ciudad);
    }

    @Override
    public void eliminaCiudad(Integer id) {
		getSqlSession().delete("eliminaCiudad", id);

    }

    @Override
    public Ciudad consultaCiudad(Integer id) {
        return getSqlSession().selectOne("consultaCiudad", id);
    }

    
}
