package pe.uni.demoquery.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.uni.demoquery.dao.spec.ClienteDaoSpec;
import pe.uni.demoquery.dao.spec.CuentaDaoSpec;
import pe.uni.demoquery.dto.ClienteDto;


@Service
public class CuentaService {

	@Autowired
	private CuentaDaoSpec cuentaDao;
	
	
	public Integer getCantCuentas(){
		return cuentaDao.getCantCuentas();
	}
	
	public Double getSaldo(String moneda){
		return cuentaDao.getSaldo(moneda);
	}
	
	
	public void procRetiro(String cuenta, Double importe, String clave, String empleado){
		cuentaDao.procRetiro(cuenta, importe, clave, empleado);
	}

	
}
