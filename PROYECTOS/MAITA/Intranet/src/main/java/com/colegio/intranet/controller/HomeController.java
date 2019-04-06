package com.colegio.intranet.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.colegio.intranet.dto.AlumnoDto;
import com.colegio.intranet.service.AlumnoService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private AlumnoService alumnoService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String search(AlumnoDto searchForm, Model model){
		List<AlumnoDto> results = alumnoService.findAlumnos(searchForm);
		model.addAttribute("results", results);
		return "list";
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(@RequestParam("id") Integer id, Model model){
		
		AlumnoDto alumno = new AlumnoDto();
		alumno.setSexo("1");
		
		if(id>0){
			alumno = alumnoService.getAlumno(id);
		}
		model.addAttribute("alumno", alumno);
		return "edit";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.GET)
	public @ResponseBody String save(AlumnoDto searchForm, Model model){
		
		String respuesta = "OK";
		try {
			alumnoService.save(searchForm);			
			respuesta = "Proceso ejecutado correctamente.";
		} catch (Exception e) {
			respuesta = e.getMessage();
		}
		return respuesta;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public @ResponseBody String delete(@RequestParam("id") Integer id, Model model){
		
		String respuesta = "OK";
		try {
			alumnoService.delete(id);			
			respuesta = "Se elimino correctamente.";
		} catch (Exception e) {
			respuesta = e.getMessage();
		}
		return respuesta;
	}	
}
