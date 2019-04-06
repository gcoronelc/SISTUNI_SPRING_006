package pe.egcc.app.controller;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pe.egcc.app.model.EstudianteBean;
import pe.egcc.app.service.EstudianteService;

/**
 * 
 * 
 * @author Gustavo Coronel
 * @blog   gcoronelc.blogspot.com
 *
 */
@Controller
public class HomeController {

  private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

  @Inject
  private EstudianteService estudianteService;

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public ModelAndView home() {

    logger.info("Cargando la página principal.");
    
    EstudianteBean bean = new EstudianteBean();
    bean.setNombre("Gustavo");
    bean.setNota1(18);
    bean.setNota2(20);
    ModelAndView view = new ModelAndView("home","panchito", bean);
    return view;

  }

  @RequestMapping(value = "/doProcesarEstudiante.htm", method = RequestMethod.POST)
  public ModelAndView doProcesarEstudiante(EstudianteBean estudianteBean) {

    logger.info("Inicio de proceso.");

    // Validar notas
    ModelAndView view;
    if (estudianteService.validar(estudianteBean)) {
      // Notas son correctas
      logger.info("Proceso correcto.");
      estudianteService.calcPromedio(estudianteBean);
      view = new ModelAndView("resultado");
      view.addObject("estudianteBean", estudianteBean);
    } else {
      // Notas no son correctas
      logger.info("Error en las notas.");
      view = new ModelAndView("home", "panchito", estudianteBean);
      view.addObject("mensaje", "Las notas no son correctas.");
    }
    
    logger.info("Fin de proceso.");
    
    return view;
  }

}
