package pe.egcc.app.exception;

/**
 * 
 * 
 * @author Gustavo Coronel
 * @blog   gcoronelc.blogspot.com
 *
 */
public class NotaFueraDeRango extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public NotaFueraDeRango() {
    super("La nota esta fuera de rango, el rangp permitido es [0,20].");
  }

  public NotaFueraDeRango(String message) {
    super(message);
  }
  
}
