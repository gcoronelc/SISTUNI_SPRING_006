package pe.uni.demoquery.dao.spec;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import pe.uni.demoquery.dto.ClienteDto;

@Repository
public interface ClienteDaoSpec {
	
	

	
	public List<ClienteDto> getClientes( String codigo, String paterno, String materno, String nombre );

	public void registrarClientes( String paterno, String materno, String nombre, String dni, String ciudad, String direccion, String telefono, String email);
	
	

	
}
