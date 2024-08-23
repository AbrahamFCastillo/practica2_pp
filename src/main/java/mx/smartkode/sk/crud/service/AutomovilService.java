package mx.smartkode.sk.crud.service;

import java.util.List;

import mx.smartkode.sk.crud.exception.ServiceException; 
import mx.smartkode.sk.crud.model.Automovil;

public interface AutomovilService { 
    public Integer ingresaAutomovil(Automovil Automovil) throws ServiceException;
	
	public List<Automovil> consultaAutomoviles() throws ServiceException; 
	
	public void actualizaAutomovil(Automovil Automovil) throws ServiceException;
	
	public void eliminaAutomovil(Integer id) throws ServiceException;
	
	public Automovil consultaAutomovil(Integer id) throws ServiceException;
}

