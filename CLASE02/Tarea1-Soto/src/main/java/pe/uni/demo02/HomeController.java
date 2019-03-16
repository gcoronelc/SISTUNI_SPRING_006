package pe.uni.demo02;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		
		return "home";
		
	}
	
	@RequestMapping(value = "/calcular.htm", method = RequestMethod.POST)
	public String Sumar1(HttpServletRequest request, Model model) {
		
		// Datos
		int precio = Integer.parseInt(request.getParameter("num1"));
		int cantidad = Integer.parseInt(request.getParameter("num2"));
		
		// Proceso
		int importe=precio*cantidad;
		double impuesto=importe*0.10;
		double total=importe+impuesto;
		
		// Reporte
		model.addAttribute("importe", importe);
		model.addAttribute("impuesto", impuesto);
		model.addAttribute("total", total);
		
		return "home";
		
	}
	
	
	
}
