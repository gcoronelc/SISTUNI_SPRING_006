package pe.egcc.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

  @Autowired
  private EstudianteService estudianteService;

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String home() {

    logger.info("Cargando la página principal.");

    // ModelAndView view = new ModelAndView("home","estudianteBean", new
    // EstudianteBean());

    return "home";

  }

  @RequestMapping(value = "/formulario.htm", method = RequestMethod.GET)
  public ModelAndView formulario() {

    logger.info("Cargando la página principal.");

    ModelAndView view = new ModelAndView("formulario", "estudianteBean", new EstudianteBean());

    return view;

  }

  @RequestMapping(value = "/doProcesarEstudiante.htm", method = RequestMethod.POST)
  public ModelAndView doProcesarEstudiante(EstudianteBean estudianteBean) {

    logger.info("Inicio de proceso.");

    // Validar notas
    logger.info("Validando la notas.");
    if (!estudianteService.validar(estudianteBean)) {
      logger.info("Error en las notas.");
      throw new RuntimeException("Las notas no son correctas.");
    }
    logger.info("Validación conforme.");

    // Procediendo a calcular el promedio
    logger.info("Calculando el promedio.");
    estudianteService.calcPromedio(estudianteBean);

    // Preparando la salida
    logger.info("Creando el objeto ModelAndView.");
    ModelAndView view = new ModelAndView("resultado");
    view.addObject("estudianteBean", estudianteBean);

    // Mostrando la vista y fin del proceso
    logger.info("Fin de proceso.");
    return view;

  }


}
