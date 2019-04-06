package pe.uni.demoquery.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import pe.uni.demoquery.service.CuentaService;


@Controller
public class CuentasController {
	
	@Autowired
	private CuentaService cuentaService;
	
	private Gson gson;
	
	@PostConstruct
	public void InicializarObject() {
		gson = new Gson();
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
			this.cuentaService.procRetiro(cuenta, importe, clave, "0003");
			respuesta = "Proceso ejecutado correctamente.";
		} catch (Exception e) {
			respuesta = e.getMessage();
		}
		return respuesta;
	}
	
}
