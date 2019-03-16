package pe.uni.demo03.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pe.uni.demo03.service.MateService;

@Controller
public class HomeController {
	
	@Autowired
	private MateService mateService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {	
		return "home";
	}
	
	
	@RequestMapping(value = "/sumar.ya", method = RequestMethod.POST)
	public ModelAndView Sumar(
			@RequestParam("num1") int n1,
			@RequestParam("num2") int n2
	) {
		
		ModelAndView mav = new ModelAndView("home");
		
		// Proceso
		int suma = mateService.sumar(n1, n2);
		
		// Reporte
		mav.addObject("n1", n1);
		mav.addObject("n2", n2);
		mav.addObject("suma", suma);
		
		return mav;
		
	}
}
