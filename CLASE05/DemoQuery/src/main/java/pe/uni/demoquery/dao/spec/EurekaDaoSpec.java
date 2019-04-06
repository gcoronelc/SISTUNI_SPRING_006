package pe.uni.demoquery.dao.spec;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import pe.uni.demoquery.dto.ClienteDto;

@Repository
public interface EurekaDaoSpec {
	
	
	public Integer getCantCuentas();
	
	public Double getSaldo( String moneda );
	
	public ClienteDto getCliente( String codigo );
	
	public ClienteDto getCliente2( String codigo );

	public Map<String, Object> getCliente3(String codigo);
	
	public List<ClienteDto> getClientes( String paterno );
	
	public List<ClienteDto> getClientes2( String paterno );
	
	
	public List<Map<String,Object>> getClientes3( String paterno );
	
	
	public List<Map<String,Object>> getClientes( 
			String codigo, String paterno, String materno, String nombre );
	
	
	public List<ClienteDto> getClientes2( 
			String codigo, String paterno, String materno, String nombre );
	
	
	public void procRetiro( 
			String cuenta, Double importe, String clave, String empleado );
	
	public void procRetiro2( 
			String cuenta, Double importe, String clave, String empleado );
	
	
}
