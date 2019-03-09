package demo02B;

import javax.inject.Named;

/**
 *
 * @author Gustavo
 */
@Named
public class MateService {

   public int sumar(int n1, int n2) {
      return (n1 + n2);
   }

}
