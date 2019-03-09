package demo02A;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Gustavo
 */
@Component
public class MateFacade {
   
   @Autowired
   private MateService mateService;


   public int sumar( int n1, int n2){
      return mateService.sumar(n1, n2);
   }
   
   
}
