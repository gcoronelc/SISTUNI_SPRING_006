package pe.egcc.app.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import pe.egcc.app.exception.NotaFueraDeRango;
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

  public void validar(EstudianteBean estudianteBean) {
    List<Integer> lista = new ArrayList<Integer>();
    if(!esCorrecta(estudianteBean.getNota1())){
      lista.add(estudianteBean.getNota1());
    }
    if(!esCorrecta(estudianteBean.getNota2())){
      lista.add(estudianteBean.getNota2());
    }
    if(!lista.isEmpty()){
      String mensaje = lista.get(0).toString();
      for(int i = 1; i < lista.size(); i++){
        mensaje += "," + lista.get(i).toString();
      }
      if(mensaje.indexOf(",") > -1){
        mensaje = "Las siguientes notas (" + mensaje + ") estan fuera de rango.";
      } else {
        mensaje = "Las siguiente nota "+ mensaje + ", esta fuera de rango.";
      }
      throw new NotaFueraDeRango(mensaje);
    }
  }

  private boolean esCorrecta(int nota) {
    boolean correcta;
    correcta = (nota >= 0 && nota <= 20) ? true : false;
    return correcta;
  }
}
