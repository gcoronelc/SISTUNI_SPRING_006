package pe.uni.demo03.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pe.uni.demo03.bean.NotasDto;
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
	public ModelAndView Sumar(@ModelAttribute NotasDto dto) {
		
		ModelAndView mav = new ModelAndView("home");
		
		// Proceso
		dto = mateService.promediar(dto);
		
		// Reporte
		mav.addObject("dto", dto);
		
		return mav;
		
	}
}
