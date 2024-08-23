package mx.smartkode.sk.crud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import mx.smartkode.sk.crud.Constantes;
import mx.smartkode.sk.crud.dao.CiudadDao;
import mx.smartkode.sk.crud.exception.ServiceException;
import mx.smartkode.sk.crud.model.Ciudad;
import mx.smartkode.sk.crud.service.CiudadService; 

@Service("ciudadService")
public class CiudadServiceImpl implements CiudadService{
    @Autowired
    private CiudadDao CiudadDao;

	public Log log = LogFactory.getLog(CiudadServiceImpl.class);

    @Override
    public Integer ingresaCiudad(Ciudad Ciudad) throws ServiceException {
        Integer id = null;
        try {
            id = CiudadDao.ingresaCiudad(Ciudad);
        } catch (Exception e) {
            log.error("ERROR EN CAPA DE SERVICIO: "+e.getMessage());
			throw new ServiceException(Constantes.ERROR_AGREGAR, "Error al agregar Ciudad");
        }
        return id;
    }

    @Override
    public List<Ciudad> consultaCiudades() throws ServiceException {
        List<Ciudad> Ciudades = null;
		try {
			Ciudades = CiudadDao.consultaCiudades();
		} catch (Exception e) {
			log.error("ERROR EN CAPA DE SERVICIO: "+e.getMessage());
			throw new ServiceException(Constantes.ERROR_CONSULTA, "Error al consultar registros");
		}
		return Ciudades;    
    }

    @Override
    public void actualizaCiudad(Ciudad Ciudad) throws ServiceException {
        try {
            if (Ciudad.getId() == null) {
				throw new RuntimeException("Es requerido el ID.");
            }
            else {
                Ciudad consulta = this.consultaCiudad(Ciudad.getId());
                if (consulta == null) {
					throw new RuntimeException("El Ciudad no existe."); 
                }
                CiudadDao.actualizaCiudad(Ciudad);
            }
        } catch (Exception e) {
            log.error("ERROR EN CAPA DE SERVICIO: "+e.getMessage());
			if(e instanceof RuntimeException) {
				throw new ServiceException(Constantes.ERROR_EDITAR, "Error al actualizar Ciudad, "+e.getMessage());
			}
			throw new ServiceException(Constantes.ERROR_EDITAR, "Error al actualizar Ciudad");
        }    
    }

    @Override
    public void eliminaCiudad(Integer id) throws ServiceException {
        try {
			CiudadDao.eliminaCiudad(id);
		} catch (Exception e) {
			log.error("ERROR EN CAPA DE SERVICIO: "+e.getMessage());
			throw new ServiceException(Constantes.ERROR_EDITAR, "Error al eliminar Ciudad");
		}
    }

    @Override
    public Ciudad consultaCiudad(Integer id) throws ServiceException {
        Ciudad Ciudad = null;
		try {
			Ciudad = CiudadDao.consultaCiudad(id);
		} catch (Exception e) {
			log.error("ERROR EN CAPA DE SERVICIO: "+e.getMessage());
			throw new ServiceException(Constantes.ERROR_CONSULTA, "Error al consultar registro");
		}
		return Ciudad;
    }
    
}
