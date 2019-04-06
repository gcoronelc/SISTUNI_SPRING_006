package pe.uni.demoquery.dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.uni.demoquery.dao.mapper.ClienteMapper;
import pe.uni.demoquery.dao.spec.ClienteDaoSpec;
import pe.uni.demoquery.dto.ClienteDto;

@Repository
public class ClienteDao extends AbstractDaoSupport implements ClienteDaoSpec{



	@Override
	public List<ClienteDto> getClientes(String codigo, String paterno, String materno, String nombre) {
	// Consulta
			String sql = "SELECT "
					+ "CHR_CLIECODIGO , VCH_CLIEPATERNO , "
					+ "VCH_CLIEMATERNO , VCH_CLIENOMBRE , CHR_CLIEDNI , "
					+ "VCH_CLIECIUDAD , VCH_CLIEDIRECCION , "
					+ "VCH_CLIETELEFONO , VCH_CLIEEMAIL  "
					+ "FROM  EUREKA.CLIENTE "
					+ "WHERE CHR_CLIECODIGO = NVL2(?,?,CHR_CLIECODIGO) "
					+ "AND   VCH_CLIEPATERNO LIKE NVL2(?,? || '%',VCH_CLIEPATERNO) "
					+ "AND   VCH_CLIEMATERNO LIKE NVL2(?,? || '%',VCH_CLIEMATERNO) "
					+ "AND   VCH_CLIENOMBRE LIKE NVL2(?,? || '%',VCH_CLIENOMBRE) "; 
			// Parametros
			Object[] parametros = {codigo, codigo, paterno, paterno, materno, materno, nombre, nombre};
			// La consulta
			List<ClienteDto> lista = jdbcTemplate.query(sql, new ClienteMapper(), parametros);
			return lista;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	@Override
	public void registrarClientes(String paterno, String materno, String nombre, String dni,String ciudad, String direccion, String telefono, String email) {
		String SQL;
		
		String  codigo;
		// Verificar la cuenta
		SQL = "select substr('00000'||to_char(max(TO_NUMBER(chr_cliecodigo))+1),LENGTH('00000'||to_char(max(TO_NUMBER(chr_cliecodigo))+1))-4,LENGTH('00000'||to_char(max(TO_NUMBER(chr_cliecodigo))+1))) as codigo from eureka.cliente  ";
		codigo = jdbcTemplate.queryForObject(SQL, String.class);
		
		
		// Registrar movimiento
		SQL = " insert into eureka.cliente(chr_cliecodigo,vch_cliepaterno,vch_cliematerno,  vch_clienombre,chr_cliedni,vch_clieciudad,vch_cliedireccion, vch_clietelefono,vch_clieemail)\r\n" + 
				"    values(?,?,?,?,?,?,?,?,?)";
		jdbcTemplate.update(SQL, codigo, paterno,  materno, nombre, dni,  ciudad, direccion, telefono, email);
		
	}

}
