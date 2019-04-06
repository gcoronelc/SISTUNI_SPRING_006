package com.colegio.intranet.dao;

import java.util.List;

import com.colegio.intranet.dto.AlumnoDto;

public interface AlumnoDao {
	public List<AlumnoDto> findAlumnos(AlumnoDto form);
	public AlumnoDto getAlumno(Integer id);
	public void update(AlumnoDto form);
	public void create(AlumnoDto form);
	public void delete(Integer id);
}
