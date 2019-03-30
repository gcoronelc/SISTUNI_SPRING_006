package pe.uni.demoquery.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import pe.uni.demoquery.service.EurekaService;


@Controller
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
	
	
}
