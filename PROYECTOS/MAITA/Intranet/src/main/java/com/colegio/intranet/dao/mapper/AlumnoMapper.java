package com.colegio.intranet.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.colegio.intranet.dto.AlumnoDto;

public class AlumnoMapper implements RowMapper<AlumnoDto>{

	@Override
	public AlumnoDto mapRow(ResultSet rs, int n) throws SQLException {
		AlumnoDto dto = new AlumnoDto();
		dto.setIdAlumno(rs.getInt("idAlumno"));
		dto.setNombres(rs.getString("nombres"));
		dto.setApePaterno(rs.getString("apePaterno"));
		dto.setApeMaterno(rs.getString("apeMaterno"));
		dto.setDni(rs.getString("dni"));
		dto.setSexo(rs.getString("sexo"));
		return dto;
	}

}

