package pe.uni.demoquery.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.uni.demoquery.dao.spec.EurekaDaoSpec;
import pe.uni.demoquery.dto.ClienteDto;

@Service
public class EurekaService {

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
	
}
