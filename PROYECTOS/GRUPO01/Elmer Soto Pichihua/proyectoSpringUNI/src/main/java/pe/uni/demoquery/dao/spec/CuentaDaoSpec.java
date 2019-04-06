package pe.uni.demoquery.dao.spec;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import pe.uni.demoquery.dto.ClienteDto;

@Repository
public interface CuentaDaoSpec {
	
	
	public Integer getCantCuentas();
	
	public Double getSaldo( String moneda );
	
	
	public void procRetiro( String cuenta, Double importe, String clave, String empleado );

	
}
