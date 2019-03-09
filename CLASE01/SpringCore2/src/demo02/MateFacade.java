package demo02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;

/**
 *
 * @author Gustavo
 */
@Component
public class MateFacade {
   
   private MateService mateService;

   @Autowired
   public void setMateService(MateService mateService) {
      this.mateService = mateService;
   }

   public int sumar( int n1, int n2){
      return mateService.sumar(n1, n2);
   }
   
   
}
