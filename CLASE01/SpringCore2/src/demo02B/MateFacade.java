package demo02B;

import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Gustavo
 */
@Named
public class MateFacade {
   
   @Inject
   private MateService mateService;


   public int sumar( int n1, int n2){
      return mateService.sumar(n1, n2);
   }
   
   
}
