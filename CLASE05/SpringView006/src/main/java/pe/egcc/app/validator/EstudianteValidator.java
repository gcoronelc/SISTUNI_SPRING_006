package pe.egcc.app.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import pe.egcc.app.model.EstudianteBean;

/**
 * 
 * 
 * @author Gustavo Coronel
 * @blog   gcoronelc.blogspot.com
 *
 */
public class EstudianteValidator implements Validator {

  @Override
  public boolean supports(Class clazz) {
    return EstudianteBean.class.equals(clazz);
  }

  @Override
  public void validate(Object target, Errors errors) {
    EstudianteBean estudianteBean = (EstudianteBean) target;

    if (estudianteBean.getNombre() == null || estudianteBean.getNombre().length() == 0) {
      errors.rejectValue("nombre", "field.nombre.required");
    }

    if (!esCorrecta(estudianteBean.getNota1())) {
      Object[] args = {estudianteBean.getNota1()};
      errors.rejectValue("nota1", "field.nota.invalid", args, "Error en la nota.");
    }

    if (!esCorrecta(estudianteBean.getNota2())) {
      Object[] args = {estudianteBean.getNota2()};
      errors.rejectValue("nota2", "field.nota.invalid", args, "Error en la nota.");
    }

  }

  private boolean esCorrecta(int nota) {
    boolean correcta;
    correcta = (nota >= 0 && nota <= 20) ? true : false;
    return correcta;
  }
}
