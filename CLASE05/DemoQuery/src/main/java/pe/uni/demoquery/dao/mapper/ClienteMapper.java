package pe.uni.demoquery.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import pe.uni.demoquery.dto.ClienteDto;

public class ClienteMapper implements RowMapper<ClienteDto>{

	@Override
	public ClienteDto mapRow(ResultSet rs, int n) throws SQLException {
		ClienteDto dto = new ClienteDto();
		dto.setCodigo(rs.getString("CHR_CLIECODIGO"));
		dto.setPaterno(rs.getString("VCH_CLIEPATERNO"));
		dto.setMaterno(rs.getString("VCH_CLIEMATERNO"));
		dto.setNombre(rs.getString("VCH_CLIENOMBRE"));
		dto.setDni(rs.getString("CHR_CLIEDNI"));
		dto.setCiudad(rs.getString("VCH_CLIECIUDAD"));
		dto.setDireccion(rs.getString("VCH_CLIEDIRECCION"));
		dto.setTelefono(rs.getString("VCH_CLIETELEFONO"));
		dto.setEmail(rs.getString("VCH_CLIEEMAIL"));
		return dto;
	}

}

