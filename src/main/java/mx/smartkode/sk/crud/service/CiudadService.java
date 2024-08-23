package mx.smartkode.sk.crud.service;

import java.util.List;

import mx.smartkode.sk.crud.exception.ServiceException;
import mx.smartkode.sk.crud.model.Ciudad;

public interface CiudadService {
    public Integer ingresaCiudad(Ciudad Ciudad) throws ServiceException;
	
	public List<Ciudad> consultaCiudades() throws ServiceException; 
	
	public void actualizaCiudad(Ciudad Ciudad) throws ServiceException;
	
	public void eliminaCiudad(Integer id) throws ServiceException;
	
	public Ciudad consultaCiudad(Integer id) throws ServiceException;
}

