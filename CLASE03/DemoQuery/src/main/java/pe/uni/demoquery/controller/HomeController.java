package pe.uni.demoquery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pe.uni.demoquery.service.EurekaService;


@Controller
public class HomeController {
	
	@Autowired
	private EurekaService eurekaService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		
		model.addAttribute("CantCuentas", eurekaService.getCantCuentas());
		model.addAttribute("SaldoSoles", eurekaService.getSaldo("01"));
		model.addAttribute("SaldoDolares", eurekaService.getSaldo("02"));
		model.addAttribute("Cliente", eurekaService.getCliente3("00001"));
		
		model.addAttribute("ListaClientes", eurekaService.getClientes3("A"));
				
		return "home";
	}
	
}
