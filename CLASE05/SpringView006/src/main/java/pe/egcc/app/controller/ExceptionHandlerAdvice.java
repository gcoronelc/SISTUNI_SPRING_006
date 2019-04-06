package pe.egcc.app.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import pe.egcc.app.exception.NotaFueraDeRango;

/**
 * 
 * 
 * @author Gustavo Coronel
 * @blog   gcoronelc.blogspot.com
 *
 */
@ControllerAdvice
public class ExceptionHandlerAdvice {

  @ExceptionHandler(ArithmeticException.class)
  public ModelAndView handleArithmeticException(Exception ex) {

    ModelAndView view = new ModelAndView("error/exception");
    view.addObject("clase", ex.getClass().getSimpleName());
    view.addObject("mensaje", "No se puede dividir por cero.");

    return view;

  }

  @ExceptionHandler(Exception.class)
  public ModelAndView handleAllException(Exception ex) {

    ModelAndView view = new ModelAndView("error/exception");
    view.addObject("clase", ex.getClass().getSimpleName());
    view.addObject("mensaje", ex.getMessage());

    return view;

  }

}
