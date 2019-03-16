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
	
	@RequestMapping(value = "/sumar.ya1", method = RequestMethod.POST)
	public String Sumar1(HttpServletRequest request, Model model) {
		
		// Datos
		int n1 = Integer.parseInt(request.getParameter("num1"));
		int n2 = Integer.parseInt(request.getParameter("num2"));
		
		// Proceso
		int suma = n1 + n2;
		
		// Reporte
		model.addAttribute("n1", n1);
		model.addAttribute("n2", n2);
		model.addAttribute("suma", suma);
		
		return "home";
		
	}
	
	@RequestMapping(value = "/sumar.ya2", method = RequestMethod.POST)
	public String Sumar2(
			@RequestParam("num1") int n1,
			@RequestParam("num2") int n2, 
			Model model
	) {
		
		// Proceso
		int suma = n1 + n2;
		
		// Reporte
		model.addAttribute("n1", n1);
		model.addAttribute("n2", n2);
		model.addAttribute("suma", suma);
		
		return "home";
		
	}
	
}
