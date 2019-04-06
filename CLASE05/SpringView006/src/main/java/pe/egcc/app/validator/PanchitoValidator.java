package pe.egcc.app.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import pe.egcc.app.model.Venta;


public class PanchitoValidator implements Validator{

  @Override
  public boolean supports(Class clazz) {
    return Venta.class.equals(clazz);
  }

  @Override
  public void validate(Object arg0, Errors arg1) {
    
  }

}
