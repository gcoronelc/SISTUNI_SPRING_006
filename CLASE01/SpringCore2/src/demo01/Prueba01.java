package demo01;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Gustavo
 */
public class Prueba01 {

   public static void main(String[] args) {
      
      String xmlFile = "/demo01/contexto01.xml";
      BeanFactory bf; 
      bf = new ClassPathXmlApplicationContext(xmlFile);
      
      MateService service;
      service = (MateService) bf.getBean("mateService");
      
      System.out.println("7 + 8 = " + service.sumar(7, 8));
      
   }
   
}
