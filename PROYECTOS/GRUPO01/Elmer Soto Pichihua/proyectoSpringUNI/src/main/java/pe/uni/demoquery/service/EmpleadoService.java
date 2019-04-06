package pe.uni.demoquery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.uni.demoquery.dao.spec.ClienteDaoSpec;
import pe.uni.demoquery.dao.spec.EmpleadoDaoSpec;
import pe.uni.demoquery.dto.ClienteDto;
import pe.uni.demoquery.dto.EmpleadoDto;


@Service
public class EmpleadoService {

	@Autowired
	private EmpleadoDaoSpec empleadoDao;
	


	public EmpleadoDto validar(String usuario, String clave) {
		
		EmpleadoDto obj = empleadoDao.validar(usuario,clave);
		return obj;
	}

	
}
