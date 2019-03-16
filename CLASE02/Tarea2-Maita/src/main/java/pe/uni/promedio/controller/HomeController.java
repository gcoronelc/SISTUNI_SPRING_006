package pe.uni.promedio.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pe.uni.promedio.service.MaterService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private MaterService mateService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {			
		return "home";
	}
	
	@RequestMapping(value = "/promedio", method = RequestMethod.POST)
	public ModelAndView calcularImporte(@RequestParam("n1") double n1, @RequestParam("n2") double n2,
			@RequestParam("n3") double n3, @RequestParam("n4") double n4){
		
		ModelAndView response = new ModelAndView("home");	
		
		
		double[] results = mateService.getPromedio(n1, n2, n3, n4);
		
		response.addObject("n1", n1);
		response.addObject("n2", n2);
		response.addObject("n3", n3);
		response.addObject("n4", n4);
		response.addObject("menorNota", results[1]);
		response.addObject("promedio", results[0]);
		
		return response;
		
	}
	
}
