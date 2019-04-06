package pe.uni.demoquery.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import pe.uni.demoquery.dto.ClienteDto;
import pe.uni.demoquery.dto.EmpleadoDto;

public class EmpleadoMapper implements RowMapper<EmpleadoDto>{

	@Override
	public EmpleadoDto mapRow(ResultSet rs, int n) throws SQLException {
		
		EmpleadoDto dto = new EmpleadoDto();
		dto.setCodigo(rs.getString("CHR_EMPLCODIGO"));
		dto.setPaterno(rs.getString("VCH_EMPLPATERNO"));
		dto.setMaterno(rs.getString("VCH_EMPLMATERNO"));
		dto.setNombre(rs.getString("VCH_EMPLNOMBRE"));
		dto.setCiudad(rs.getString("VCH_EMPLCIUDAD"));
		dto.setDireccion(rs.getString("VCH_EMPLDIRECCION"));
		dto.setUsuario(rs.getString("VCH_EMPLUSUARIO"));

		return dto;
	}

}

  