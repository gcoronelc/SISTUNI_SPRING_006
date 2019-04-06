package com.colegio.intranet.dao.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.colegio.intranet.dao.AlumnoDao;
import com.colegio.intranet.dao.mapper.AlumnoMapper;
import com.colegio.intranet.dto.AlumnoDto;


@Repository
public class AlumnoDaoImp implements AlumnoDao {

	@Autowired
	protected JdbcTemplate jdbcTemplate;
	
	@Override
	public List<AlumnoDto> findAlumnos(AlumnoDto form) {
		
		String query = "Select * from alumno a where 1 = 1 ";
		if(form.getSexo()!=""){
			query +=" and a.sexo = '"+form.getSexo()+"' ";
		}
		if(form.getNombres()!=""){
			query += " and a.nombres like '%"+form.getNombres()+"%' ";
		}
		if(form.getApePaterno()!=""){
			query += " and a.apePaterno like '%"+form.getApePaterno()+"%' ";
		}
		if(form.getDni()!=""){
			query += " and a.dni = '"+form.getDni()+"' ";
		}
		if(form.getApeMaterno()!=""){
			query +=" and a.apeMaterno like '%"+form.getApeMaterno()+"%' ";
		}
		
		List<AlumnoDto> lista;
		
		lista = jdbcTemplate.query(query, new AlumnoMapper());
		return lista;
	}

	@Override
	public AlumnoDto getAlumno(Integer id) {
		
		String query = "Select * from Alumno a where a.idAlumno = "+id;
		AlumnoDto alumno = jdbcTemplate.queryForObject(query, new AlumnoMapper());
		
		return alumno;
	}

	@Override
	public void update(AlumnoDto form) {
		String query = "UPDATE alumno set nombres = ?, apePaterno=?, apeMaterno=?, dni=?, sexo=? where idAlumno = ?";
		int filas = jdbcTemplate.update(query, form.getNombres(), form.getApePaterno(), form.getApeMaterno(), form.getDni(), form.getSexo(), form.getIdAlumno());
		if( filas == 0 ){
			throw new RuntimeException("no se ha logrado actualizar el alumno");
		}
	}

	@Override
	public void create(AlumnoDto form) {
		String query = "INSERT INTO alumno(nombres, apePaterno, apeMaterno, dni, sexo) values (?,?,?,?,?)";
		jdbcTemplate.update(query, form.getNombres(), form.getApePaterno(), form.getApeMaterno(), form.getDni(), form.getSexo());		
	}

	@Override
	public void delete(Integer id) {
		String query = "DELETE from alumno where idAlumno = "+id;
		int filas = jdbcTemplate.update(query);
		if( filas == 0 ){
			throw new RuntimeException("no se ha logrado eliminar el alumno");
		}
	}


}
