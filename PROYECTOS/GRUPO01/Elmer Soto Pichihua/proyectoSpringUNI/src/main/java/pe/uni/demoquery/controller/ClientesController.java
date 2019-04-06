package pe.uni.demoquery.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import pe.uni.demoquery.dto.ClienteDto;
import pe.uni.demoquery.service.ClienteService;


@Controller
public class ClientesController {
	
	@Autowired
	private ClienteService clienteService;
	
	private Gson gson;
	
	@PostConstruct
	public void InicializarObject() {
		gson = new Gson();
	}
	

	
	@RequestMapping(value = "/ConsultarClientes.htm", method = RequestMethod.GET)
	public String ConsultarClientes() {	
		return "ConsultarClientes";
	}
	
	@RequestMapping(value = "/ConsultarClientesResp.htm", method = RequestMethod.GET)
	public @ResponseBody String ConsultarClientesResp1(@RequestParam("codigo") String codigo, @RequestParam("paterno") String paterno, @RequestParam("materno") String materno, @RequestParam("nombre") String nombre) {	
		
		// Proceso
		List<ClienteDto> lista = clienteService.getClientes(codigo, paterno, materno, nombre);
		String respJSON = gson.toJson(lista);
		
		
		return respJSON;
	}
	
	@RequestMapping(value = "/RegistrarClientes.htm", method = RequestMethod.POST)
	public @ResponseBody String RegistrarClientes(
			@RequestParam("paterno1") String paterno,
			@RequestParam("materno1") String materno,
			@RequestParam("nombre1") String nombre,
			@RequestParam("dni1") String dni,
			@RequestParam("ciudad1") String ciudad,
			@RequestParam("direccion1") String direccion,
			@RequestParam("telefono1") String telefono,
			@RequestParam("email1") String email) {	
		
System.out.println("-----------------------------------------------");
System.out.println(paterno);
System.out.println("-----------------------------------------------");
		
		String respuesta = "OK";
		try {
			this.clienteService.registrarClientes(paterno,  materno, nombre, dni,  ciudad, direccion, telefono, email);
			respuesta = "OK";
		} catch (Exception e) {
			respuesta = e.getMessage();
		}
		return respuesta;
	}
	
	
	
}
