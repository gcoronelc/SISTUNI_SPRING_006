package pe.uni.demoquery.dao.spec;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import pe.uni.demoquery.dto.ClienteDto;
import pe.uni.demoquery.dto.EmpleadoDto;

@Repository
public interface EmpleadoDaoSpec {
	
	

	public EmpleadoDto validar(String usuario, String clave);
	
	

	
}
