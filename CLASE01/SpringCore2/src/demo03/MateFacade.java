package demo03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Gustavo
 */
@Component
public class MateFacade {
   
   private MateService panchito;

   @Autowired
   public MateFacade(MateService panchito) {
      this.panchito = panchito;
   }

   
   public int sumar( int n1, int n2){
      return panchito.sumar(n1, n2);
   }
   
   
}
