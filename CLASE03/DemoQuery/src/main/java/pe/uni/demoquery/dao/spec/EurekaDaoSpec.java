package pe.uni.demoquery.dao.spec;

import org.springframework.stereotype.Repository;

import pe.uni.demoquery.dto.ClienteDto;

@Repository
public interface EurekaDaoSpec {
	
	
	public Integer getCantCuentas();
	
	public Double getSaldo( String moneda );
	
	public ClienteDto getCliente( String codigo );
	
	

}
