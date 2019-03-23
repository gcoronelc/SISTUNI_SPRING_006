package pe.uni.demoquery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.uni.demoquery.dao.spec.EurekaDaoSpec;

@Service
public class EurekaService {

	@Autowired
	private EurekaDaoSpec eurekaDao;
	
	
	public Integer getCantCuentas(){
		return eurekaDao.getCantCuentas();
	}
	
	public Double getSaldo(){
		return eurekaDao.getSaldo();
	}
	
}
