package pe.uni.demoquery.dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
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

	@Override
	public ClienteDto getCliente2(String codigo) {
		String sql = "SELECT CHR_CLIECODIGO codigo, VCH_CLIEPATERNO paterno, "
				+ "VCH_CLIEMATERNO materno, VCH_CLIENOMBRE nombre, CHR_CLIEDNI dni, "
				+ "VCH_CLIECIUDAD ciudad, VCH_CLIEDIRECCION direccion, "
				+ "VCH_CLIETELEFONO telefono, VCH_CLIEEMAIL email "
				+ "FROM EUREKA.CLIENTE WHERE CHR_CLIECODIGO = ?";
		ClienteDto dto;
		dto = jdbcTemplate.queryForObject(sql, 
				new BeanPropertyRowMapper(ClienteDto.class), codigo);
		return dto;
	}
	
	@Override
	public Map<String, Object> getCliente3(String codigo) {
		String sql = "SELECT CHR_CLIECODIGO codigo, VCH_CLIEPATERNO paterno, "
				+ "VCH_CLIEMATERNO materno, VCH_CLIENOMBRE nombre, CHR_CLIEDNI dni, "
				+ "VCH_CLIECIUDAD ciudad, VCH_CLIEDIRECCION direccion, "
				+ "VCH_CLIETELEFONO telefono, VCH_CLIEEMAIL email "
				+ "FROM EUREKA.CLIENTE WHERE CHR_CLIECODIGO = ?";
		Map<String,Object> dto;
		dto = jdbcTemplate.queryForMap(sql, codigo);
		return dto;
	}
	
	
	public List<ClienteDto> getClientes( String paterno ){
		String sql = "SELECT CHR_CLIECODIGO, VCH_CLIEPATERNO, "
				+ "VCH_CLIEMATERNO, VCH_CLIENOMBRE, CHR_CLIEDNI, "
				+ "VCH_CLIECIUDAD, VCH_CLIEDIRECCION, VCH_CLIETELEFONO, "
				+ "VCH_CLIEEMAIL FROM EUREKA.CLIENTE "
				+ "WHERE VCH_CLIEPATERNO LIKE ?";
		List<ClienteDto> lista;
		lista = jdbcTemplate.query(sql, new ClienteMapper(), "%" + paterno + "%");
		return lista;
	}
	
	
	public List<ClienteDto> getClientes2( String paterno ){
		String sql = "SELECT CHR_CLIECODIGO codigo, VCH_CLIEPATERNO paterno, "
				+ "VCH_CLIEMATERNO materno, VCH_CLIENOMBRE nombre, CHR_CLIEDNI dni, "
				+ "VCH_CLIECIUDAD ciudad, VCH_CLIEDIRECCION direccion, "
				+ "VCH_CLIETELEFONO telefono, VCH_CLIEEMAIL email "
				+ "FROM EUREKA.CLIENTE WHERE VCH_CLIEPATERNO LIKE ?";
		List<ClienteDto> lista;
		lista = jdbcTemplate.query(sql, 
				new BeanPropertyRowMapper(ClienteDto.class), "%" + paterno + "%");
		return lista;
	}
	
	
	public List<Map<String,Object>> getClientes3( String paterno ){
		String sql = "SELECT CHR_CLIECODIGO codigo, VCH_CLIEPATERNO paterno, "
				+ "VCH_CLIEMATERNO materno, VCH_CLIENOMBRE nombre, CHR_CLIEDNI dni, "
				+ "VCH_CLIECIUDAD ciudad, VCH_CLIEDIRECCION direccion, "
				+ "VCH_CLIETELEFONO telefono, VCH_CLIEEMAIL email "
				+ "FROM EUREKA.CLIENTE WHERE VCH_CLIEPATERNO LIKE ?";
		List<Map<String,Object>> lista;
		lista = jdbcTemplate.queryForList(sql, "%" + paterno + "%");
		return lista;
	}
	
	
}
