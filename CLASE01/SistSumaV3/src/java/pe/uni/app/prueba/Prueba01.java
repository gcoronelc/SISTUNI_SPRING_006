package pe.uni.app.prueba;

import pe.uni.app.service.MateService;

/**
 *
 * @author Gustavo
 */
public class Prueba01 {

   public static void main(String[] args) {
      // Datos
      int num1 = 56;
      int num2 = 65;
      // Proceso
      MateService mateService = new MateService();
      int suma = mateService.sumar(num1, num2);
      // Reporte
      System.out.println("Número 1: " + num1);
      System.out.println("Número 2: " + num2);
      System.out.println("Suma: " + suma);
   }
   
}
