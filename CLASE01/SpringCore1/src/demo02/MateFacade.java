package demo02;

/**
 *
 * @author Gustavo
 */
public class MateFacade {
   
   private MateService panchito;

   public void setPanchito(MateService panchito) {
      this.panchito = panchito;
   }
   
   
   public int sumar( int n1, int n2){
      return panchito.sumar(n1, n2);
   }
   
   
}
