package mx.smartkode.sk.crud.dao;

import java.util.List;

import mx.smartkode.sk.crud.model.Ciudad; 

public interface CiudadDao {
    public Integer ingresaCiudad(Ciudad Ciudad);
	
	public List<Ciudad> consultaCiudades();
	
	public void actualizaCiudad(Ciudad Ciudad);
	
	public void eliminaCiudad(Integer id);
	
	public Ciudad consultaCiudad(Integer id);

}
