package pe.uni.demoquery.service;

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
}
