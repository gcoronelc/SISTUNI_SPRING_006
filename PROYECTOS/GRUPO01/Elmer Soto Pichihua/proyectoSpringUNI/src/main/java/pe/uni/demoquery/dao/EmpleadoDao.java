package pe.uni.demoquery.dao;

import org.springframework.stereotype.Repository;

import pe.uni.demoquery.dao.mapper.EmpleadoMapper;
import pe.uni.demoquery.dao.spec.EmpleadoDaoSpec;
import pe.uni.demoquery.dto.EmpleadoDto;

@Repository
public class EmpleadoDao extends AbstractDaoSupport implements EmpleadoDaoSpec {

	@Override
	public EmpleadoDto validar(String usuario, String clave) {
		
		System.out.println(usuario);
		System.out.println(clave);
		
		String sql = "SELECT CHR_EMPLCODIGO    ,VCH_EMPLPATERNO   ,VCH_EMPLMATERNO   , VCH_EMPLNOMBRE    ,VCH_EMPLCIUDAD    , VCH_EMPLDIRECCION ,VCH_EMPLUSUARIO    FROM EUREKA.EMPLEADO\r\n"
				+ "		WHERE VCH_EMPLUSUARIO = ?	AND VCH_EMPLCLAVE = ?";
		Object[] parametros = {usuario, clave};
		EmpleadoDto dto = jdbcTemplate.queryForObject(sql, new EmpleadoMapper(), parametros);
		
		System.out.println("Proceso Login");
		return dto;
	}

}
