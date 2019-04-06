package pe.egcc.app.service;

import javax.inject.Named;

import pe.egcc.app.model.EstudianteBean;

/**
 * 
 * 
 * @author Gustavo Coronel
 * @blog   gcoronelc.blogspot.com
 *
 */
@Named
public class EstudianteService {

  public void calcPromedio(EstudianteBean estudianteBean) {
    // Variables
    int pr;
    String condicion;
    // Proceso
    pr = (estudianteBean.getNota1() + estudianteBean.getNota2()) / 2;
    condicion = (pr >= 14) ? "Aprobado" : "Desaprobado";
    // Salida
    estudianteBean.setProm(pr);
    estudianteBean.setCondicion(condicion);
  }

  public boolean validar(EstudianteBean estudianteBean) {
    boolean rpta = false;
    if (esCorrecta(estudianteBean.getNota1()) && esCorrecta(estudianteBean.getNota2())) {
      rpta = true;
    }
    return rpta;
  }

  private boolean esCorrecta(int nota) {
    boolean correcta;
    correcta = (nota >= 0 && nota <= 20) ? true : false;
    return correcta;
  }
}
