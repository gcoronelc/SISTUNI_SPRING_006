package pe.uni.demoquery.dao;

import org.springframework.stereotype.Repository;

import pe.uni.demoquery.dao.mapper.ClienteMapper;
import pe.uni.demoquery.dao.spec.EurekaDaoSpec;
import pe.uni.demoquery.dto.ClienteDto;

@Repository
public class EurekaDao extends AbstractDaoSupport implements EurekaDaoSpec{

	@Override
	public Integer getCantCuentas() {
		String sql= "select count(*) from eureka.cuenta";
		int rowCount= jdbcTemplate.queryForObject(sql,Integer.class);
		return rowCount;
	}

	@Override
	public Double getSaldo( String moneda ) {
		String sql= "select sum(dec_cuensaldo) from eureka.cuenta "
				+ "where chr_monecodigo = ?";
		Double saldo = jdbcTemplate.queryForObject(sql, Double.class, moneda);
		return saldo;
	}

	@Override
	public ClienteDto getCliente(String codigo) {
		String sql = "SELECT CHR_CLIECODIGO, VCH_CLIEPATERNO, "
				+ "VCH_CLIEMATERNO, VCH_CLIENOMBRE, CHR_CLIEDNI, "
				+ "VCH_CLIECIUDAD, VCH_CLIEDIRECCION, VCH_CLIETELEFONO, "
				+ "VCH_CLIEEMAIL FROM EUREKA.CLIENTE WHERE CHR_CLIECODIGO = ?";
		ClienteDto dto = jdbcTemplate.queryForObject(sql, new ClienteMapper(), codigo);
		return dto;
	}

	
	
}
