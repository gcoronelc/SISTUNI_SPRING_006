package com.colegio.intranet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colegio.intranet.dao.imp.AlumnoDaoImp;
import com.colegio.intranet.dto.AlumnoDto;

@Service
public class AlumnoService {
	@Autowired
	private AlumnoDaoImp alumnoDao;
	
	public List<AlumnoDto> findAlumnos(AlumnoDto form) {
		return alumnoDao.findAlumnos(form);
	}
	
	public AlumnoDto getAlumno(Integer id) {
		return alumnoDao.getAlumno(id);
	}
	
	public void save(AlumnoDto form){
		if(form.getIdAlumno()==null){
			alumnoDao.create(form);
		}else{
			alumnoDao.update(form);
		}
	}
	
	public void delete(Integer id){
		alumnoDao.delete(id);
	}
}
