package pe.uni.demoquery.controller;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import pe.uni.demoquery.dto.EmpleadoDto;
import pe.uni.demoquery.service.EmpleadoService;


@Controller
public class LoginController {
	
	@Autowired
	private EmpleadoService  empleadoServices;
	
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
	
	
	@RequestMapping(value = "/LogonIngresar.htm", method = RequestMethod.POST)
	public @ResponseBody String login(@RequestParam("usuario") String usuario, @RequestParam("clave") String clave, HttpServletRequest request) {
		
	System.out.println(usuario);
		
	    String validador ="OK";
	    try {
	     EmpleadoDto empleadoDto = empleadoServices.validar(usuario, clave);
	     
	     if(empleadoDto == null){
	        throw new RuntimeException("Datos no son correctos.");
	      }
	     
	     final String ID = request.getSession().getId();
         request.getSession().setAttribute("ID", ID);
         request.getSession().setAttribute("usuario", empleadoDto);
         validador ="OK";
	      
	    } catch (Exception e) {
	    	validador ="ERROR";
	    }
	    return validador;
	}
	
	
	@RequestMapping(value = "/Principal.htm", method = RequestMethod.GET)
	public String PaginaPrincipal() {	
		return "Principal";
	}

	
	@RequestMapping(value = "/salir.htm", method = RequestMethod.GET)
	public String salir(HttpServletRequest request) {	
		
	request.getSession().invalidate();
		return "index";
	}

}
