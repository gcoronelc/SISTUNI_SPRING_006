package pe.uni.demo03.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pe.uni.demo03.bean.Notas;
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
			@RequestParam("num2") int n2,
			@RequestParam("num3") int n3,
			@RequestParam("num4") int n4
	) {
		
		ModelAndView mav = new ModelAndView("home");
		
		// Proceso
		Notas obj = new Notas();
		
		obj = mateService.Promedio(n1, n2,n3,n4);
		
		// Reporte
		mav.addObject("notas", obj.getNotas());
		mav.addObject("notaEliminada", obj.getNotasEliminadas());
		mav.addObject("promedio", obj.getPromedio());
		mav.addObject("estado", obj.getEstado());
		
		return mav;
		
	}
}
