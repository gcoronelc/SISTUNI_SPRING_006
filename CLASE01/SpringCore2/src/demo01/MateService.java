package demo01;

import org.springframework.stereotype.Component;

/**
 *
 * @author Gustavo
 */
@Component
public class MateService {

   public int sumar(int n1, int n2) {
      return (n1 + n2);
   }

}
