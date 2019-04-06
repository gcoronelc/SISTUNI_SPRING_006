package pe.uni.demoquery.dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
	
	public List<Map<String,Object>> getClientes( 
			String codigo, String paterno, String materno, String nombre )
	{
		// Consulta
		String sql = "SELECT "
				+ "CHR_CLIECODIGO codigo, VCH_CLIEPATERNO paterno, "
				+ "VCH_CLIEMATERNO materno, VCH_CLIENOMBRE nombre, CHR_CLIEDNI dni, "
				+ "VCH_CLIECIUDAD ciudad, VCH_CLIEDIRECCION direccion, "
				+ "VCH_CLIETELEFONO telefono, VCH_CLIEEMAIL email "
				+ "FROM  EUREKA.CLIENTE "
				+ "WHERE CHR_CLIECODIGO = NVL2(?,?,CHR_CLIECODIGO) "
				+ "AND   VCH_CLIEPATERNO LIKE NVL2(?,? || '%',VCH_CLIEPATERNO) "
				+ "AND   VCH_CLIEMATERNO LIKE NVL2(?,? || '%',VCH_CLIEMATERNO) "
				+ "AND   VCH_CLIENOMBRE LIKE NVL2(?,? || '%',VCH_CLIENOMBRE) "; 
		// Parametros
		Object[] parametros = {codigo, codigo, paterno, paterno, materno, materno, nombre, nombre};
		// La consulta
		List<Map<String,Object>> lista;
		lista = jdbcTemplate.queryForList(sql, parametros);
		return lista;
	}

	@Override
	public List<ClienteDto> getClientes2(String codigo, String paterno, String materno, String nombre) {
	// Consulta
			String sql = "SELECT "
					+ "CHR_CLIECODIGO codigo, VCH_CLIEPATERNO paterno, "
					+ "VCH_CLIEMATERNO materno, VCH_CLIENOMBRE nombre, CHR_CLIEDNI dni, "
					+ "VCH_CLIECIUDAD ciudad, VCH_CLIEDIRECCION direccion, "
					+ "VCH_CLIETELEFONO telefono, VCH_CLIEEMAIL email "
					+ "FROM  EUREKA.CLIENTE "
					+ "WHERE CHR_CLIECODIGO = NVL2(?,?,CHR_CLIECODIGO) "
					+ "AND   VCH_CLIEPATERNO LIKE NVL2(?,? || '%',VCH_CLIEPATERNO) "
					+ "AND   VCH_CLIEMATERNO LIKE NVL2(?,? || '%',VCH_CLIEMATERNO) "
					+ "AND   VCH_CLIENOMBRE LIKE NVL2(?,? || '%',VCH_CLIENOMBRE) "; 
			// Parametros
			Object[] parametros = {codigo, codigo, paterno, paterno, materno, materno, nombre, nombre};
			// La consulta
			List<ClienteDto> lista;
			lista = jdbcTemplate.query(sql, new BeanPropertyRowMapper(ClienteDto.class), parametros);
			return lista;
	}

	@Transactional( propagation=Propagation.REQUIRES_NEW,
			rollbackFor=Exception.class)
	@Override
	public void procRetiro(String cuenta, Double importe, String clave, String empleado) {
		String SQL;
		Integer conta;
		// Verificar la cuenta
		SQL = "SELECT COUNT(1) FILAS  "
				+ "FROM EUREKA.CUENTA "
				+ "WHERE CHR_CUENCODIGO = ? "
				+ "AND   CHR_CUENCLAVE = ? "
				+ "AND   VCH_CUENESTADO = 'ACTIVO'";
		conta = jdbcTemplate.queryForObject(SQL, Integer.class, cuenta, clave);
		if( conta == 0){
			throw new RuntimeException("Cuenta no existe.");
		}
		// Datos de la cuenta
		SQL = "SELECT DEC_CUENSALDO SALDO, INT_CUENCONTMOV CONTMOV "
				+ "FROM EUREKA.CUENTA "
				+ "WHERE CHR_CUENCODIGO = ? "
				+ "FOR UPDATE";
		
		try {
			Thread.currentThread().sleep(5000);			
		} catch (Exception e) {
		}

		
		Map<String,Object> rec = jdbcTemplate.queryForMap(SQL, cuenta);
		Double saldo =Double.parseDouble(rec.get("SALDO").toString());
		Integer contMov = Integer.parseInt(rec.get("CONTMOV").toString());
		// Validar saldo
		if( saldo < importe ){
			throw new RuntimeException("No existe Saldo suficiente.");
		}
		// Actualizar datos
		saldo = saldo - importe;
		contMov++;
		SQL = "UPDATE EUREKA.CUENTA "
				+ "SET DEC_CUENSALDO = ?, "
				+ "INT_CUENCONTMOV = ? "
				+ "WHERE CHR_CUENCODIGO = ?";
		int filas = jdbcTemplate.update(SQL, saldo, contMov, cuenta);
		if( filas == 0 ){
			throw new RuntimeException("no se ha logrado actualizar la cuenta.");
		}
		// Registrar movimiento
		SQL = "INSERT INTO EUREKA.MOVIMIENTO(CHR_CUENCODIGO, "
				+ "INT_MOVINUMERO,DTT_MOVIFECHA,CHR_EMPLCODIGO, "
				+ "CHR_TIPOCODIGO,DEC_MOVIIMPORTE) "
				+ "VALUES(?,?,SYSDATE,?,'004',?) ";
		jdbcTemplate.update(SQL, cuenta, contMov, empleado, importe);
	}

	@Override
	public void procRetiro2(String cuenta, Double importe, String clave, String empleado) {

			String cmd = "call eureka.usp_egcc_retiro(?,?,?,?)";
			jdbcTemplate.update(cmd, cuenta, importe, empleado, clave);

	}
	
}
