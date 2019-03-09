package demo02A;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Gustavo
 */
public class Prueba01 {

   public static void main(String[] args) {
      
      String xmlFile = "/demo02A/contexto02A.xml";
      BeanFactory bf; 
      bf = new ClassPathXmlApplicationContext(xmlFile);
      
      MateFacade facade;
      facade = bf.getBean("mateFacade", MateFacade.class);
      
      System.out.println("7 + 8 = " + facade.sumar(7, 8));
      
   }
   
}
