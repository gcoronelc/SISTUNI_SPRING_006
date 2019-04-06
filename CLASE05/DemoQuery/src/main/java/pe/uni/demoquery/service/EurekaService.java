package pe.uni.demoquery.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import pe.uni.demoquery.dao.spec.EurekaDaoSpec;
import pe.uni.demoquery.dto.ClienteDto;

@Service
//@Scope(value = WebApplicationContext.SCOPE_SESSION)
public class EurekaService extends AbstractService{

	@Autowired
	private EurekaDaoSpec eurekaDao;
	
	
	public Integer getCantCuentas(){
		return eurekaDao.getCantCuentas();
	}
	
	public Double getSaldo(String moneda){
		return eurekaDao.getSaldo(moneda);
	}
	
	public ClienteDto getCliente( String codigo){
		return eurekaDao.getCliente(codigo);
	}
	
	public ClienteDto getCliente2( String codigo){
		return eurekaDao.getCliente2(codigo);
	}
	
	public Map<String, Object> getCliente3( String codigo){
		return eurekaDao.getCliente3(codigo);
	}
	
	public List<ClienteDto> getClientes( String paterno ){
		return eurekaDao.getClientes(paterno);
	}
	
	public List<ClienteDto> getClientes2( String paterno ){
		return eurekaDao.getClientes2(paterno);
	}
	
	public List<Map<String,Object>> getClientes3( String paterno ){
		return eurekaDao.getClientes3(paterno);
	}
	
	
	public List<Map<String,Object>> getClientes( 
			String codigo, String paterno, String materno, String nombre )
	{
		return eurekaDao.getClientes(codigo, paterno, materno, nombre);
	}
	
	
	public List<ClienteDto> getClientes2( 
			String codigo, String paterno, String materno, String nombre )
	{
		List<ClienteDto> lista;
		lista = eurekaDao.getClientes2(codigo, paterno, materno, nombre);
		
		return lista;
	}
	
	public void procRetiro(String cuenta, Double importe, String clave, String empleado){
		eurekaDao.procRetiro(cuenta, importe, clave, empleado);
	}
	
	public void procRetiro2(String cuenta, Double importe, String clave, String empleado){
		
		try {
			
			eurekaDao.procRetiro2(cuenta, importe, clave, empleado);
			this.setCode(1);
			this.setMessage("Proceso exitoso!!!");
		} catch (Exception e) {
			
			this.setCode(-1);
			this.setMessage(e.getMessage());
			
		}

	}
	
	
	
}
