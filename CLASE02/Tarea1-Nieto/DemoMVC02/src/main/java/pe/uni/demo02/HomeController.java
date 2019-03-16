package pe.uni.demo02;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
		int n1 = Integer.parseInt(request.getParameter("PrecioProd"));
		int n2 = Integer.parseInt(request.getParameter("Cantidad"));
		
		// Proceso
		int ImporteVent = n1*n2;
		double impuesto =ImporteVent*(0.18);
    double total =ImporteVent + impuesto;	
		
		// Reporte
		model.addAttribute("n1", ImporteVent);
		model.addAttribute("n2", impuesto);
		model.addAttribute("total", total);
		
		return "home";
		
	}
	
	
	
}
