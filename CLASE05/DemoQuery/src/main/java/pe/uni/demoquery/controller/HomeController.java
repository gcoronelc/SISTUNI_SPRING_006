package pe.uni.demoquery.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.google.gson.Gson;

import pe.uni.demoquery.dto.ClienteDto;
import pe.uni.demoquery.service.EGCCUtil;
import pe.uni.demoquery.service.EurekaService;


@Controller
@SessionAttributes({"usuario"})
public class HomeController {
	
	@Autowired
	private EurekaService eurekaService;
	
	private Gson gson;
	
	@PostConstruct
	public void InicializarObject() {
		gson = new Gson();
	}
	
	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		
		/*
		model.addAttribute("CantCuentas", eurekaService.getCantCuentas());
		model.addAttribute("SaldoSoles", eurekaService.getSaldo("01"));
		model.addAttribute("SaldoDolares", eurekaService.getSaldo("02"));
		model.addAttribute("Cliente", eurekaService.getCliente3("00001"));
		
		model.addAttribute("ListaClientes", eurekaService.getClientes3("A"));
		*/
		
		return "home";
	}
	
	
	@RequestMapping(value = "/Home.htm", method = RequestMethod.POST)
	public String homeProceso( @RequestParam("nombre") String nombre, Model model) {	
		model.addAttribute("usuario", nombre);
		return "index";
	}
	
	
	
	@RequestMapping(value = "/ConsultarClientes.htm", method = RequestMethod.GET)
	public String ConsultarClientes() {	
		return "ConsultarClientes";
	}
	
	@RequestMapping(value = "/ConsultarClientesResp1.htm", method = RequestMethod.GET)
	public @ResponseBody String ConsultarClientesResp1(
			@RequestParam("codigo") String codigo, 
			@RequestParam("paterno") String paterno, 
			@RequestParam("materno") String materno, 
			@RequestParam("nombre") String nombre
			) {	
		
		// Proceso
		List<Map<String, Object>> lista = eurekaService.getClientes(codigo, paterno, materno, nombre);
		String respJSON = gson.toJson(lista);
		return respJSON;
	}
	
	@RequestMapping(value = "/ConsultarClientesResp2.htm", method = RequestMethod.GET)
	public @ResponseBody String ConsultarClientesResp2(
			@RequestParam("codigo") String codigo, 
			@RequestParam("paterno") String paterno, 
			@RequestParam("materno") String materno, 
			@RequestParam("nombre") String nombre
			) {	
		
		// Proceso
		List<Map<String, Object>> lista = eurekaService.getClientes(codigo, paterno, materno, nombre);
		String cadena = EGCCUtil.ListMapToString(lista);
		return cadena;
	}
	
	@RequestMapping(value = "/ConsultarClientesResp3.htm", method = RequestMethod.GET)
	public @ResponseBody String ConsultarClientesResp3(
			@RequestParam("codigo") String codigo, 
			@RequestParam("paterno") String paterno, 
			@RequestParam("materno") String materno, 
			@RequestParam("nombre") String nombre
			) {	
		
		// Proceso
		List<ClienteDto> lista = eurekaService.getClientes2(codigo, paterno, materno, nombre);
		String cadena = EGCCUtil.ListClientesToString(lista);
		return cadena;
	}
	
	
	@RequestMapping(value = "/Retiro.htm", method = RequestMethod.GET)
	public String Retiro() {	
		return "Retiro";
	}
	
	@RequestMapping(value = "/RetiroProc.htm", method = RequestMethod.POST)
	public @ResponseBody String RetiroProc(
			@RequestParam("cuenta") String cuenta,
			@RequestParam("importe") Double importe,
			@RequestParam("clave") String clave			
			) {	
		String respuesta = "OK";
		try {
			this.eurekaService.procRetiro(cuenta, importe, clave, "0003");
			respuesta = "Proceso ejecutado correctamente.";
		} catch (Exception e) {
			respuesta = e.getMessage();
		}
		return respuesta;
	}
	
	@RequestMapping(value = "/RetiroProc2.htm", method = RequestMethod.POST, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String RetiroProc2(
			@RequestParam("cuenta") String cuenta,
			@RequestParam("importe") Double importe,
			@RequestParam("clave") String clave			
			) {	
		
		RespuestaJSON rpta = new RespuestaJSON();
		this.eurekaService.procRetiro2(cuenta, importe, clave, "0003");
		
		rpta.setCode(eurekaService.getCode());
		rpta.setMessage(eurekaService.getMessage());
		rpta.setData("que pena");
		
		return gson.toJson(rpta);
				
	}
	
}
