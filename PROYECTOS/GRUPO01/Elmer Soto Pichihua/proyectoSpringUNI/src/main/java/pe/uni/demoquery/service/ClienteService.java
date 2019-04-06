package pe.uni.demoquery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.uni.demoquery.dao.spec.ClienteDaoSpec;
import pe.uni.demoquery.dto.ClienteDto;


@Service
public class ClienteService {

	@Autowired
	private ClienteDaoSpec clienteDao;
	


	
	public List<ClienteDto> getClientes( String codigo, String paterno, String materno, String nombre )
	{
		List<ClienteDto> lista;
		lista = clienteDao.getClientes(codigo, paterno, materno, nombre);
		
		return lista;
	}




	public void registrarClientes(String paterno, String materno, String nombre, String dni,
			String ciudad, String direccion, String telefono, String email) {
		clienteDao.registrarClientes(paterno,  materno, nombre, dni,  ciudad, direccion, telefono, email);
		
	}

	
}
